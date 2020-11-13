package br.com.casadocodigo.repositories;

import br.com.casadocodigo.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Book findByTitle(String title);
    Book findByIsbn(String isbn);

}
