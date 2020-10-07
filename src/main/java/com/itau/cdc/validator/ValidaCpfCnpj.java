package com.itau.cdc.validator;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.http.HttpStatus;

import com.itau.cdc.configuration.exception.ApiErroException;
//4
public class ValidaCpfCnpj{
	//1
	public String validaCpfCnpj(String cpfCnpj) {
		//1
		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);
		//1
		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);
		//1
		if(!cpfValidator.isValid(cpfCnpj, null) && !cnpjValidator.isValid(cpfCnpj, null)) {
			throw new ApiErroException(HttpStatus.UNPROCESSABLE_ENTITY, "Documento (CPF ou CNPJ) não é válido.");
		}
		
		return cpfCnpj;
		
	}
	
}
