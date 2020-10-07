package com.itau.cdc.validator;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.http.HttpStatus;

import com.itau.cdc.exception.ApiErroException;

public class ValidaCpfCnpj{

	public String validaCpfCnpj(String cpfCnpj) {
		
		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);
		
		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);
		
		if(!cpfValidator.isValid(cpfCnpj, null) && !cnpjValidator.isValid(cpfCnpj, null)) {
			throw new ApiErroException(HttpStatus.UNPROCESSABLE_ENTITY, "Documento (CPF ou CNPJ) não é válido.");
		}
		
		return cpfCnpj;
		
	}
	
}
