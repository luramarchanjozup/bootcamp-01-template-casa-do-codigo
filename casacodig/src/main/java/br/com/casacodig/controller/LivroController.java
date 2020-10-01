package br.com.casacodig.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.casacodig.dto.CategoriaDTO;
import br.com.casacodig.error.ApiErroException;
import br.com.casacodig.model.Categoria;

@RestController
public class LivroController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping(value = "/v1/livro")
	@Transactional
	public String cria(@Valid @RequestBody CategoriaDTO categoriadto, BindingResult result) {
		try {
			//Categoria categoria = categoriaservice.salvar(categoriadto);
			//manager.persist(categoria);
			//return categoria.toString();
			return "em construção";
		} catch (Exception e) {
			throw new ApiErroException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}
