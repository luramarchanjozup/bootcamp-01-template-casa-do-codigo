package br.com.zup.bootcamp.database.repository;

import br.com.zup.bootcamp.database.model.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<Author, String> {
    @Query(value = "select * from author where email = :email", nativeQuery = true)
    Optional<Author> findByEmail(@Param("email") String email);
}
