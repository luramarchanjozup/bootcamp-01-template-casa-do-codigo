package br.com.casacodig.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

public class ValidadorDocumento implements ConstraintValidator<DocumentoValido, String>{
	
	private String atributo;
	private String classe;

	@Override
	public void initialize(DocumentoValido  params) {
		atributo = params.campo();
	}


	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		System.out.println("-------------TESTE VALIDADOR DOCUMENTO------------------");
		System.out.println(value);
		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);
		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);

		return cpfValidator.isValid(value, null) || cnpjValidator.isValid(value, null);
	}	

}
