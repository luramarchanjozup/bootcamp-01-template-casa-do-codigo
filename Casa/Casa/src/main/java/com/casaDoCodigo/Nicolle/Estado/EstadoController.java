package com.casaDoCodigo.Nicolle.Estado;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.casaDoCodigo.Nicolle.Pais.PaisRepository;

@RestController
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping(value = "/casa/estado")
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public void novo(@RequestBody @Valid NovoEstadoForm form) {
		Estado novoEstado = form.novoEstado(paisRepository);
		System.out.println(novoEstado);
		estadoRepository.save(novoEstado);
		

	}
}