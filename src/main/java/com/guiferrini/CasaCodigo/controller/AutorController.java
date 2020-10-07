package com.guiferrini.CasaCodigo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	//public Autor createAutor(@Valid @RequestBody Autor autor) {
	public ResponseEntity<Autor> insert(@Valid @RequestBody Autor autor){
		Autor obj = autorRepo.save(autor);
		
		//validando se email já existe
		if(obj.getEmail() == autor.getEmail()) {
			return ResponseEntity.status(400).body(obj);
		} else {
		
			//salvanbdo no BD
			if(obj instanceof Autor) {
				return ResponseEntity.status(200).body(obj);
			} else {
				return ResponseEntity.status(400).body(obj);
			}
		}
	}
	
	//Listando Autores
	//@GetMapping
	

}