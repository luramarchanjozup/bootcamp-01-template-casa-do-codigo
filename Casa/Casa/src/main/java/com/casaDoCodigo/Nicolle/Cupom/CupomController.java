package com.casaDoCodigo.Nicolle.Cupom;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CupomController {

	@Autowired
	private CupomRepository cupomRepository;

	@PostMapping(value = "/casa/cupom")
	@Transactional
	public void novo(@RequestBody @Valid NovoCupomform form) {
		Cupom novoCupom = form.novoCupom();
		cupomRepository.save(novoCupom);
	}
	
	@PutMapping(value="/casa/cupom/{id}")
	@Transactional
	public ResponseEntity<Cupom> update(@PathVariable("id") long id,  @RequestBody NovoCupomform form) {
	   return cupomRepository.findById(id).map(record -> {
		   System.out.println(record);
	               record.setCodigo(form.getCodigo());
	               record.setDesconto(form.getDesconto());
	               record.setValidade(form.getValidade());
	               Cupom updated = cupomRepository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}

}
