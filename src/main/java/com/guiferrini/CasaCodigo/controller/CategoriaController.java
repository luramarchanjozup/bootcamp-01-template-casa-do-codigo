package com.guiferrini.CasaCodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guiferrini.CasaCodigo.model.Categoria;
import com.guiferrini.CasaCodigo.model.CategoriaDTO;
import com.guiferrini.CasaCodigo.model.CategoriaDuplicadoValidador;

@RestController

@RequestMapping("/categoria")
public class CategoriaController {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	private CategoriaDuplicadoValidador categoriaDuplicadoValidador;
	
	@InitBinder
	public void init(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(categoriaDuplicadoValidador);
	}
	
	@PostMapping
	@Transactional
	public String criarNovaCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO) {
		Categoria obj = new Categoria(categoriaDTO.getNome());
		//if(categoriaDTO.getNome() == entityManager.getReference(categoriaDTO.getNome(), primaryKey)) {
			//return "Categoria já acdastrada";
		//}
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
		//entityManager.close();
		return obj.toString();
	}	
}
