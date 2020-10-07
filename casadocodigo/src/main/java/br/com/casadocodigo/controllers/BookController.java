package br.com.casadocodigo.controllers;
import br.com.casadocodigo.dtos.BookDto;
import br.com.casadocodigo.forms.BookForm;
import br.com.casadocodigo.models.Book;
import br.com.casadocodigo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> createBook(@RequestBody @Valid BookForm bookForm){

                                         //+1
        entityManager.persist(bookForm.toEntity(entityManager));

        return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){

        //+1
        try{

            //+1
            List<BookDto> booksDtos = new ArrayList<>();

            //+1
            entityManager
                    .createQuery("SELECT b FROM Book b", Book.class)
                    .getResultList()
                    .forEach(book -> booksDtos.add(new BookDto(book)));
                                                          // +1

            return ResponseEntity.ok(booksDtos);

        }catch(RuntimeException exception){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){

        //+1
        try{

            Book book = entityManager.find(Book.class, id);

            //+1
            return  book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();

        }catch(RuntimeException exception){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }
}
