package br.com.zup.bootcamp.database.repository;

import br.com.zup.bootcamp.database.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, String> {
}
