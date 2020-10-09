package br.com.casacodig.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.casacodig.dto.CupomDTO;
import br.com.casacodig.dto.CupomUpdateDTO;
import br.com.casacodig.error.ApiErroException;
import br.com.casacodig.model.Cupom;
import br.com.casacodig.services.CupomServices;

@RestController
public class CupomController {

	@Autowired
	private CupomServices cupomServices;
	
	@PostMapping(value = "/v1/cupom", produces = "application/json")
	@Transactional
	public ResponseEntity<?> cadastrarCupom(@Valid @RequestBody CupomDTO cupomdto){
		try {
			Cupom cupom = cupomServices.salvar(cupomdto);
			return new ResponseEntity<>(cupom,HttpStatus.OK);
		} catch (Exception e) {
			throw new ApiErroException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@PutMapping(value = "/v1/cupom", produces = "application/json")
	@Transactional
	public ResponseEntity<?> atualizarCupom(@Valid @RequestBody CupomUpdateDTO cupomdto){
		try {
			//System.out.println("-------------CUPOM UPDATE CONTROLLER------------------");
			//System.out.println(cupomdto.toString());
			Cupom cupom = cupomServices.atualizar(cupomdto);
			return new ResponseEntity<>(cupom,HttpStatus.OK);
		} catch (Exception e) {
			throw new ApiErroException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
