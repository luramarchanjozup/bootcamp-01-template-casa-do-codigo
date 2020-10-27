package com.casaDoCodigo.Nicolle.Pais;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaisController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping(value = "/casa/pais")
	@ResponseStatus(HttpStatus.CREATED)
	public void novoPais(@RequestBody @Valid NovoPaisForm form) {
		Pais novoPais = form.novoPais();
		paisRepository.save(novoPais);
	}
}
