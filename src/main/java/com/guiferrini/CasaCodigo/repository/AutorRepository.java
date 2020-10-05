package com.guiferrini.CasaCodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guiferrini.CasaCodigo.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> { //herança JpaReposritory<usa o model/Entidade 'Autor', Tipo do identificador único>
	
}
