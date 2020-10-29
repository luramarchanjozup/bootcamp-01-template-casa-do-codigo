package bootcamp.challenges.casadocodigo.controllers;

import bootcamp.challenges.casadocodigo.dtos.BookDto;
import bootcamp.challenges.casadocodigo.entities.Book;
import bootcamp.challenges.casadocodigo.entities.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/books")
@RestController
public class BookController {

    private Logger log = LoggerFactory.getLogger(BookController.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @PostMapping
    public ResponseEntity<Void> bookRegister(@RequestBody @Valid BookDto bookDto){
        Book book = bookDto.toModel(entityManager);
        entityManager.persist(book);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(book.getId()).toUri()).build();
    }

    @GetMapping
    public ResponseEntity<List<Item>> bookList(){
        if (allBooks().isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(allBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> bookDetail(@PathVariable("id") Long id){
        if (detail(id) == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(detail(id));
    }

    private List<Item>  allBooks() {
        List<Item> items = (List<Item>) entityManager.createQuery("SELECT book.id,book.title FROM Book book").getResultStream().map(
                (Object objArray) -> {
                    Object[] array = (Object[]) objArray;
                    Map<String,String> book = new HashMap<String, String>();
                    book.put("ID",array[0].toString());
                    book.put("Título",array[1].toString());
                    return book;
                }
        ).collect(Collectors.toList());
        return items;
    }
    private Book detail(Long id) {
        return entityManager.find(Book.class, id);
    }
}
