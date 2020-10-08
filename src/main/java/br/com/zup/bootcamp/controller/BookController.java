package br.com.zup.bootcamp.controller;

import br.com.zup.bootcamp.controller.model.BookRequest;
import br.com.zup.bootcamp.controller.model.GenericResponse;
import br.com.zup.bootcamp.domain.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Optional;

// Intrinsic charge = 4
@RestController
@RequestMapping("/book")
public class BookController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<GenericResponse> register(@Validated @RequestBody BookRequest request){
        Book newBook = request.convert();
        manager.persist(newBook);

        GenericResponse response = new GenericResponse("The book was registered");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    @Transactional
    public ResponseEntity<GenericResponse> consult(){
        Query query = manager.createQuery("select b from " + Book.class.getName() + " b");

        GenericResponse response = new GenericResponse(query.getResultList());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<GenericResponse> consultOne(@PathVariable("id") String id){
        GenericResponse response;
        Optional<Book> book = Optional.of(manager.find(Book.class, id));

        if(book.isEmpty()){
            response = new GenericResponse("Book not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        response = new GenericResponse(book.get());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
