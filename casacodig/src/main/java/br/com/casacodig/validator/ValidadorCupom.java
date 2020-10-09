package br.com.casacodig.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.casacodig.model.Cupom;
import br.com.casacodig.repositories.CupomRepository;

public class ValidadorCupom implements ConstraintValidator<CupomValido, String>{
	
	private String atributo;
	
	@Autowired
	private CupomRepository cupomRepository;

	@Override
	public void initialize(CupomValido  params) {
		atributo = params.campo();
	}


	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == "" || value == null) {
			return true;
		}
		
		Cupom cupom = cupomRepository.findByCodigo(value);
		
		if (cupom != null && cupom.validaData() == true) {
			System.out.println("Cupom não nulo");
			return true;
		}
		
		return false;
	}	

}
