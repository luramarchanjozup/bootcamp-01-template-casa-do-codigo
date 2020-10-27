package com.casadocodigo.casadocodigo.Cupom;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CuponsController {

	@Autowired
	private CupomRepository cr;

	@PostMapping("/cupom")
	@Transactional
	public String cadastraCupom(@RequestBody @Valid CupomDto dto) {
		Cupom cupom = dto.toModel();
		cr.save(cupom);
		return cupom.toString();
	}

	@PutMapping("/cupom/{codigo}")
	@Transactional
	public String alteraCupom(@RequestBody @Valid CupomAtualiza novosDados, @PathVariable String codigo) {
		Cupom cupom = cr.findByCodigo(codigo);
		cupom = novosDados.atualizarCupom(cupom);
		cr.save(cupom);
		return cupom.toString();

	}
}