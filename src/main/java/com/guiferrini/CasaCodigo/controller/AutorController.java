package com.guiferrini.CasaCodigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guiferrini.CasaCodigo.model.Autor;
import com.guiferrini.CasaCodigo.repository.AutorRepository;


@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired AutorRepository autorRepo;
	
	//Criando Autor
	@CrossOrigin
	@PostMapping
	public Autor createAutor(@RequestBody Autor autor) {
		Autor obj = autorRepo.save(autor);
		return obj;
	}
	
	//Listando Autores
	//@GetMapping
	
	
}
