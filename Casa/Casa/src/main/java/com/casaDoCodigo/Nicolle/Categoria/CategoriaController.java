package com.casaDoCodigo.Nicolle.Categoria;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping(value = "/casa/categoria")
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public void novo(@RequestBody @Valid NovaCategoriaForm form) {
		Categoria novaCategoria = form.novaCategoria();
		categoriaRepository.save(novaCategoria);
	}

}
