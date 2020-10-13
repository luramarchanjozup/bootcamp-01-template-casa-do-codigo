package com.guiferrini.CasaCodigo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guiferrini.CasaCodigo.model.NovoLivro;
import com.guiferrini.CasaCodigo.model.NovoLivroDTO;

@RestController
@RequestMapping("/novolivro")
public class NovoLivroController {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public ResponseEntity<NovoLivro> criaNovoLivro(@Valid @RequestBody NovoLivroDTO novoLivroDTO) {
		
		NovoLivro obj = novoLivroDTO.toModel(entityManager);
		entityManager.persist(obj);
		
		if(obj instanceof NovoLivro) {
			return ResponseEntity.status(201).body(obj);
		} else {
			return ResponseEntity.status(400).body(obj); 
		}
	}
	
	@GetMapping
	@Transactional
	public ResponseEntity<List<NovoLivro>> busca(){
		
		Query query = entityManager.createQuery("Select x from " + NovoLivro.class.getName() + " x");
		
		List<NovoLivro> list = new ArrayList<>();
		
		list.addAll(query.getResultList());
		
		if(list instanceof NovoLivro) {
			return ResponseEntity.status(200).body(list);			
		} else {
			return ResponseEntity.status(500).body(list);
		}	
	}
}








