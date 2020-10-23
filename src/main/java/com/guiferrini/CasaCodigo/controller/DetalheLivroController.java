package com.guiferrini.CasaCodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guiferrini.CasaCodigo.model.NovoLivro;
import com.guiferrini.CasaCodigo.model.NovoLivroDTO;

@RestController
@RequestMapping("/detalhe/{id}")
public class DetalheLivroController {

	@PersistenceContext
	EntityManager entityManager;
	
	@GetMapping//1
	public ResponseEntity<?> buscaPorId(@PathVariable("id") String id) {
		//1
		NovoLivro obj = entityManager.find(NovoLivro.class, id);

		//1
		if(obj == null) {
			return ResponseEntity.status(404).body("ID inexistente. Favor verificar o ID do Livro informado.");
		}
		//1
		NovoLivroDTO rFinal = new NovoLivroDTO(
				obj.getTitulo(), 
				obj.getResumo(), 
				obj.getSumario(), 
				obj.getPreco(), 
				obj.getPaginas(), 
				obj.getIdentificador(), 
				obj.getDate(), 
				obj.getCategoria().getNome(),
				obj.getAutor().getNome() 
				);		
		  
		return ResponseEntity.status(HttpStatus.OK).body(rFinal);
	}
}
