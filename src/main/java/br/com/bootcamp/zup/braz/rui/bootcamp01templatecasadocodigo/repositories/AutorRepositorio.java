package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.repositories;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepositorio extends JpaRepository<Autor, Integer>{
}
