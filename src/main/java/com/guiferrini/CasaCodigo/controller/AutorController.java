package com.guiferrini.CasaCodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guiferrini.CasaCodigo.model.Autor;
import com.guiferrini.CasaCodigo.model.AutorDTO;
import com.guiferrini.CasaCodigo.repository.AutorRepository;


@RestController

@RequestMapping("/autor")
public class AutorController {
	
	//1
	@Autowired AutorRepository autorRepo; //responseEntity - alternativa EntityManager - são 2 coisaas diferentes
	
	//Criando Autor
	@CrossOrigin
	@PostMapping
	//1
	public ResponseEntity<AutorDTO> insert(@Valid @RequestBody AutorDTO autorDTO){
		//1
		Autor obj = autorRepo.save(autorDTO.toModel()); //converte AutoprDTo em Autor - protegendo a borda
		//1
		//salvanbdo no BD
		if(obj instanceof Autor) {
			return ResponseEntity.status(200).body(autorDTO);
		} 
		//1
		else {
			return ResponseEntity.status(400).body(autorDTO);
		}
	}
}

	

