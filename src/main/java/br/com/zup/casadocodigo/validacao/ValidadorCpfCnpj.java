package br.com.zup.casadocodigo.validacao;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.novacompra.NovaCompraDTO;

public class ValidadorCpfCnpj implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return NovaCompraDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		NovaCompraDTO novaCompra = (NovaCompraDTO) target;
		if (!novaCompra.documentoValido()) {
			errors.rejectValue("documento", null, "documento precisa ser cpf ou cnpj");
		}

	}

}
