package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.domain.Book;
import br.com.zup.casadocodigo.dto.BookDTO;
import br.com.zup.casadocodigo.dto.BookDetailsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="books")
public class BookController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional

    public ResponseEntity<?> create(@RequestBody @Valid BookDTO bookDto) {
        Book createdBook = bookDto.toModel(entityManager);
        entityManager.persist(createdBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @GetMapping
    public ResponseEntity<?> list() {
        try{
            Query query = entityManager.createQuery("SELECT b FROM books b", Book.class);
            List<Book> books = query.getResultList();
            return ResponseEntity.status(HttpStatus.OK).body(books);
        }
        catch(Exception err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> detailsBook(@PathVariable("id") Long id) {
        Book oneBook = entityManager.find(Book.class, id);

        if(oneBook == null) {
            return ResponseEntity.notFound().build();
        }

        BookDetailsDTO bookDetailsDTO = new BookDetailsDTO(oneBook);

        return ResponseEntity.ok(bookDetailsDTO);
    }

}
