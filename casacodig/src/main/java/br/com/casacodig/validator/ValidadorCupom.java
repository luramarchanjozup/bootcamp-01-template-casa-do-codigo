package br.com.casacodig.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.casacodig.model.Cupom;
import br.com.casacodig.repositories.CupomRepository;


//Contagem de Pontos - TOTAL:3
//1 - CupomRepository
//1 - Cupom
//2 - If

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
			return true;
		}
		
		return false;
	}	

}
