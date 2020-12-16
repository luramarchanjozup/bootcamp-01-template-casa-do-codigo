package br.com.zup.cdc.nicolle.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.cdc.nicolle.model.Pais;
import br.com.zup.cdc.nicolle.repository.PaisRepository;
import br.com.zup.cdc.nicolle.request.NovoPaisRequest;

@RestController
@RequestMapping(value = "/casadocodigo/pais")
public class PaisController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Pais> criaPais(@RequestBody @Valid NovoPaisRequest request){
		Pais novoPais = request.novoPais();
		paisRepository.save(novoPais);
		
		return ResponseEntity.ok().build();
		
	}

}
