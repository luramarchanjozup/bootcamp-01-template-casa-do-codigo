package br.com.zup.cdc.nicolle.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.cdc.nicolle.model.Categoria;
import br.com.zup.cdc.nicolle.repository.CategoriaRepository;
import br.com.zup.cdc.nicolle.request.NovaCategoriaRequest;

@RestController
public class CategoriasController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping(value = "/casadocodigo/categoria")
	@Transactional
	public ResponseEntity<Categoria> novaCategoria(@RequestBody @Valid NovaCategoriaRequest request) {
		Categoria novaCategoria = request.novaCategoria();
		categoriaRepository.save(novaCategoria);
		return ResponseEntity.ok().build();
	}
}
