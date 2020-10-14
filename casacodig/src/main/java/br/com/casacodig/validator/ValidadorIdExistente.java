package br.com.casacodig.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//Contagem de Pontos - TOTAL:1
//1 - If

public class ValidadorIdExistente implements ConstraintValidator<IdExistente, Long>{

	private String atributo;
	private String classe;
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void initialize(IdExistente params) {
		atributo = params.campo();
		classe = params.classe();
	}

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		Query query = manager.createQuery("select 1 from "+classe+" where "+atributo+"=:value");
		query.setParameter("value", value);
		
		List<?> list = query.getResultList();
		
		if (list.size() >= 1) {
			return true;
		}
		return false;
	}
}
