package br.com.zup.bootcamp.controller;

import br.com.zup.bootcamp.controller.model.BuyerRequest;
import br.com.zup.bootcamp.controller.model.GenericResponse;
import br.com.zup.bootcamp.domain.model.Buyer;
import br.com.zup.bootcamp.domain.model.State;
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
import java.util.Collection;

// Intrinsic charge = 5
@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @PersistenceContext
    EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<GenericResponse> register(@Validated @RequestBody BuyerRequest request){
        Buyer newBuyer = request.convert();
        GenericResponse response;

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
