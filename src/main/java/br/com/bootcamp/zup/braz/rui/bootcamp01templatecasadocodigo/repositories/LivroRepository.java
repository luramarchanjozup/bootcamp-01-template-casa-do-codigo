package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.repositories;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
