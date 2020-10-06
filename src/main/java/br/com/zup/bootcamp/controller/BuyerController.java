package br.com.zup.bootcamp.controller;

import br.com.zup.bootcamp.controller.model.BuyerRequest;
import br.com.zup.bootcamp.controller.model.GenericResponse;
import br.com.zup.bootcamp.controller.model.ItemRequest;
import br.com.zup.bootcamp.domain.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;

// Intrinsic charge = 9
@RestController
@RequestMapping("/buy")
public class BuyerController {

    @PersistenceContext
    EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<GenericResponse> register(@Validated @RequestBody BuyerRequest request){
        GenericResponse response;
        Buyer newBuyer = request.convert();
        Purchase newPurchase = request.getCart().convert(newBuyer);
        newBuyer.setPurchase(newPurchase);

        if(request.getCart().getTotal() <= 0){
            response = new GenericResponse("Total must to be greater than 0");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
        }

        Collection<Item> items = new ArrayList<>();
        float total = 0;
        for (ItemRequest itemRequest : request.getCart().getItems()) {
            Item item = itemRequest.convert();
            Book book = manager.find(Book.class, item.getBook().getIsbn());
            total += book.getPrice() * item.getAmount();
            item.setPurchase(newPurchase);
            items.add(item);
        }
        newPurchase.setItems(items);

        if(total != newPurchase.getTotal()){
            response = new GenericResponse("The total request is different from the calculated");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
        }

        if(newBuyer.getState() != null){
            Query query = manager.createQuery(
                    "select b.country from " + State.class.getName() + " b where country_id = :value"
            );
            query.setParameter("value", newBuyer.getCountry().getId());
            Collection<State> resultList = query.getResultList();

            if(resultList.isEmpty()){
                response = new GenericResponse("Country not have this state");
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
            }
        }

        manager.persist(newBuyer);

        response = new GenericResponse("Buyer was registered");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
