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

        //+1
        if(book != null) {
            bookRepository.save(book);
            return ResponseEntity.ok(new BookDto(book));
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){

        List<BookDto> booksDtos = new ArrayList<>();

        //+1
        List<Book> books = bookRepository.findAll();

        //+1
        if(books != null) {

            //+1
            books.forEach(book -> booksDtos.add(new BookDto(book)));

            return ResponseEntity.ok(booksDtos);
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id){

        //+1
        if(bookRepository.existsById(id)) {

            //+1
            Book book = bookRepository.findById(id).orElseThrow();
            return ResponseEntity.ok(new BookDto(book));

        }

        return ResponseEntity.notFound().build();

    }
}
