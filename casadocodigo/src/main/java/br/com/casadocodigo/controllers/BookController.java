package br.com.casadocodigo.controllers;
import br.com.casadocodigo.dtos.BookDto;
import br.com.casadocodigo.forms.BookForm;
import br.com.casadocodigo.models.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/books")
public class BookController {

    /* pontos de dificuldade de entendimento =  6 */

    /* @complexidade (1) - acoplamento contextual */
    private final EntityManager entityManager;

    private final Logger logger = LoggerFactory.getLogger(Book.class);


    public BookController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @PostMapping
    @Transactional
    public ResponseEntity<?> createBook(@RequestBody @Valid BookForm bookForm,
                                        UriComponentsBuilder uriComponentsBuilder){

        /* @complexidade (2) - método em classe específica do projeto */
        var book = bookForm.toEntity(entityManager);
        entityManager.persist(book);

        logger.info("[NOVO LIVRO] Livro {} criado com sucesso.", book.getTitle());

        return ResponseEntity
                .created(uriComponentsBuilder.path("/api/authors").buildAndExpand().toUri())
                .body(book);

    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){

        /* @complexidade (2) - método em classe específica do projeto + forEach */
        var booksDtos = new ArrayList<BookDto>();
        entityManager
                .createQuery("SELECT b FROM Book b", Book.class)
                .getResultList()
                .forEach(book -> booksDtos.add(new BookDto(book)));

        logger.info("[INFO] Livros pesquisados com sucesso.");

        return ResponseEntity.ok(booksDtos);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){

        /* @complexidade (1) - branch */
        var book = entityManager.find(Book.class, id);
        if(book == null){
            return ResponseEntity.notFound().build();
        }

        logger.info("[INFO] Livro {} retornado com sucesso.", id);

        return  ResponseEntity.ok(book);

    }

}
