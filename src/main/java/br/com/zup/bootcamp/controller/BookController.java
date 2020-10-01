package br.com.zup.bootcamp.controller;

import br.com.zup.bootcamp.controller.model.BookRequest;
import br.com.zup.bootcamp.controller.model.GenericResponse;
import br.com.zup.bootcamp.domain.model.Book;
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
import java.time.LocalDate;

// Intrinsic charge = 4
@RestController
@RequestMapping("/book")
public class BookController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<GenericResponse> register(@Validated @RequestBody BookRequest request){
        GenericResponse response;
        if(request.getPublicationDate().isEqual(LocalDate.now())){
            response = new GenericResponse("Publication date needs to be in the future");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
        }

        Book newBook = request.convert();
        manager.persist(newBook);

        response = new GenericResponse("The book was registered");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
