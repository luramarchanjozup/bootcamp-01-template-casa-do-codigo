package br.com.casacodig.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.casacodig.dto.CompraDTO;
import br.com.casacodig.error.ApiErroException;
import br.com.casacodig.model.Compra;
import br.com.casacodig.services.CompraServices;

@RestController
public class CompraController {

	@Autowired
	private CompraServices compraservices;
	
	@PostMapping(value = "/v1/compra")
	@Transactional
	public ResponseEntity<?> criaCompra (@Valid @RequestBody CompraDTO compradto) {
		try {
			System.out.println("-------------COMPRA CONTROLLER------------------");
			System.out.println(compradto.toString());
			
			Compra compra = compraservices.salvar(compradto);
			return new ResponseEntity<>(compra,HttpStatus.OK);
			//return null;
		} catch (Exception e) {
			throw new ApiErroException(HttpStatus.BAD_REQUEST, e.getMessage());
		}	
	}
}
