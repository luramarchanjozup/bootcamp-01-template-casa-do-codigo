package br.com.casadocodigo.controllers;
import br.com.casadocodigo.dtos.BookDto;
import br.com.casadocodigo.forms.BookForm;
import br.com.casadocodigo.models.Book;
import br.com.casadocodigo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    //+1
    @Autowired
    private BookRepository bookRepository;

    @PostMapping                                                    //+1
    public ResponseEntity<BookDto> createBook(@RequestBody @Valid BookForm bookForm){

        //+1
        Book book = bookForm.toEntity();

        bookRepository.save(book);

                                        //+1
        return ResponseEntity.ok(new BookDto(book));

    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){

        //+1
        List<BookDto> booksDtos = new ArrayList<>();

        //+1
        List<Book> books = bookRepository.findAll();

        //+1
        books.forEach(book -> booksDtos.add(new BookDto(book)));

        return ResponseEntity.ok(booksDtos);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id){

        //+1
        Optional<Book> book = bookRepository.findById(id);

        //+1
        return ResponseEntity.ok(book);

    }
}
