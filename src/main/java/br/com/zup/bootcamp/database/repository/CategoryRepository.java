package br.com.zup.bootcamp.database.repository;

import br.com.zup.bootcamp.database.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, String> {
    @Query(value = "select * from category where name = name", nativeQuery = true)
    Optional<Category> findByName(@Param("name") String name);
}
