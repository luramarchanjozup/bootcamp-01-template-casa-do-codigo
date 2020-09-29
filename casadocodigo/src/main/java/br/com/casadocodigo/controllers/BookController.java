package br.com.casadocodigo.controllers;
import br.com.casadocodigo.models.Book;
import br.com.casadocodigo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody @Valid Book book){
        if(book != null) {
            bookRepository.save(book);
            return ResponseEntity.ok(book);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Book>> list(){

        List<Book> books = bookRepository.findAll();
        return ResponseEntity.ok(books);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id){

        Book book = bookRepository.findById(id).orElseThrow();

        return ResponseEntity.ok(book);

    }

}
