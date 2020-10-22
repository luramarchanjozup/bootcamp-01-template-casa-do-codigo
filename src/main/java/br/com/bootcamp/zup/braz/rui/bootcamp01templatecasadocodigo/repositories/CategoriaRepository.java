package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.repositories;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    Optional<Categoria> findByNome(String nome);
}
