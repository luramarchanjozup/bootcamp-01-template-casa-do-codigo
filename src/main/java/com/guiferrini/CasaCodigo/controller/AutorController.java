package com.guiferrini.CasaCodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guiferrini.CasaCodigo.model.Autor;
import com.guiferrini.CasaCodigo.model.AutorDTO;
import com.guiferrini.CasaCodigo.model.EmailDuplicadoValidador;
import com.guiferrini.CasaCodigo.repository.AutorRepository;


@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired AutorRepository autorRepo; //responseEntity - alternativa EntityManager - são 2 coisaas diferentes
	
	@Autowired
	private EmailDuplicadoValidador emailDuplicadoValidador;

	@InitBinder
	public void init(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(emailDuplicadoValidador);
	}
	
	//Criando Autor
	@CrossOrigin
	@PostMapping
	public ResponseEntity<AutorDTO> insert(@Valid @RequestBody AutorDTO autorDTO){
		Autor obj = autorRepo.save(autorDTO.toModel()); //converte AutoprDTo em Autor - protegendo a borda
		
		//salvanbdo no BD
		if(obj instanceof Autor) {
			return ResponseEntity.status(200).body(autorDTO);
		 } else {
			return ResponseEntity.status(400).body(autorDTO);
		 }
		}
	}
