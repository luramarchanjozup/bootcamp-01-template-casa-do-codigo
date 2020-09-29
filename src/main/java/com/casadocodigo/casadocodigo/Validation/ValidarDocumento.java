package com.casadocodigo.casadocodigo.Validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.casadocodigo.casadocodigo.FluxoPagamento.Compra.CompraDto;

@Component
public class ValidarDocumento implements Validator {
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

		if (!request.documentoValido()) {
			errors.rejectValue("documento", null, "Numero de codumento inválido!");
		}
	}
}
