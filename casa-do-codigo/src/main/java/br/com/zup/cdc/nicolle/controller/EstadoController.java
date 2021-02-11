package br.com.zup.cdc.nicolle.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.cdc.nicolle.model.Estado;
import br.com.zup.cdc.nicolle.repository.EstadoRepository;
import br.com.zup.cdc.nicolle.repository.PaisRepository;
import br.com.zup.cdc.nicolle.request.NovoEstadoRequest;
import br.com.zup.cdc.nicolle.response.PaisResponse;

@RestController
@RequestMapping(value = "/casadocodigo/estado")
public class EstadoController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	

	
	@PostMapping
	@Transactional
	public ResponseEntity<Estado> criaEstado(@RequestBody @Valid NovoEstadoRequest request){
		Estado novoEstado = request.novoEstado(paisRepository);
		System.out.println(novoEstado);
		estadoRepository.save(novoEstado);
		
		return ResponseEntity.ok().build();
		
	}

}
