package br.com.casacodig.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.casacodig.dto.CompraDTO;
import br.com.casacodig.error.ApiErroException;
import br.com.casacodig.model.Compra;
import br.com.casacodig.services.CompraServices;


//Contagem de Pontos - TOTAL:5
//1 - CompraServices
//1 - CompraDTO
//1 - Compra
//1 - Try
//1 - If


@RestController
public class CompraController {

	@Autowired
	private CompraServices compraservices;
	
	@PostMapping(value = "/v1/compra")
	@Transactional
	public ResponseEntity<?> criaCompra (@Valid @RequestBody CompraDTO compradto) {
		try {
			//System.out.println("-------------COMPRA CONTROLLER------------------");
			//System.out.println(compradto.toString());
			
			Compra compra = compraservices.salvar(compradto);
			return new ResponseEntity<>(compra,HttpStatus.OK);
		} catch (Exception e) {
			throw new ApiErroException(HttpStatus.BAD_REQUEST, e.getMessage());
		}	
	}
	
	@GetMapping(value = "/v1/listacompra/{id}", produces = "application/json")
	@Transactional
	public ResponseEntity<?> listaDetalhesCompra (@PathVariable("id") Long id) {
		Compra compra = compraservices.listarCompras(id);
		if (compra == null) {
			return new ResponseEntity<>("Não Encontrado uma Compra com ID informado",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(compra,HttpStatus.OK);
	}
	
}
