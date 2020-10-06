package com.itau.cdc.validator;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

public class ValidaCpfCnpj{

	public boolean validaCpfCnpj(String cpfCnpj) {
		
		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);
		
		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);
		
		if(cpfValidator.isValid(cpfCnpj, null) || cnpjValidator.isValid(cpfCnpj, null)) {
			return true;
		}
		
		return false;
		
	}
	
}
