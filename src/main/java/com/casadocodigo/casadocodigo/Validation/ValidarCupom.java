package com.casadocodigo.casadocodigo.Validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.casadocodigo.casadocodigo.Cupom.Cupom;
import com.casadocodigo.casadocodigo.Cupom.CupomRepository;
import com.casadocodigo.casadocodigo.FluxoPagamento.Compra.CompraDto;

@Component
public class ValidarCupom implements Validator {
	@Autowired
	CupomRepository cupomRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return CompraDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		CompraDto request = (CompraDto) target;
		Optional<String> possivelCodigo = request.getCodigoCupom();
		if (possivelCodigo.isPresent()) {
			Cupom cupom = cupomRepository.findByCodigo(possivelCodigo.get());
			if (!cupom.verificaValidade()) {
				errors.rejectValue("codigoCupom", null, "Cupom com a validade expirada!");
			}
		}
	}
}