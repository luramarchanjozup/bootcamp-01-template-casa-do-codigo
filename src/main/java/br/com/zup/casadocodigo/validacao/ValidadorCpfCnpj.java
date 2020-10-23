package br.com.zup.casadocodigo.validacao;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.novacompra.NovaCompraDTO;

//5
@Component
public class ValidadorCpfCnpj implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// 1
		return NovaCompraDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// 1
		// 1
		if (errors.hasErrors()) {
			return;
		}

		NovaCompraDTO novaCompra = (NovaCompraDTO) target;
		// 1
		// 1
		if (!novaCompra.documentoValido()) {
			errors.rejectValue("documento", null, "documento precisa ser cpf ou cnpj");
		}

	}

}
