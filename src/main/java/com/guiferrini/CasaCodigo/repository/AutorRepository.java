package com.guiferrini.CasaCodigo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.guiferrini.CasaCodigo.model.Autor;
import com.guiferrini.CasaCodigo.model.Categoria;

@Repository
//public interface AutorRepository extends JpaRepository<Autor, Long> { //herança JpaReposritory<usa o model/Entidade 'Autor', Tipo do identificador único>
public interface AutorRepository extends CrudRepository<Autor, String> { //herança JpaReposritory<usa o model/Entidade 'Autor', Tipo do identificador único>
	Optional<Autor> findByEmail(String email); 
	//Optional<Categoria> findByNome(String nome);

}

 