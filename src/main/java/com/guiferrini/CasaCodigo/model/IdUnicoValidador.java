package com.guiferrini.CasaCodigo.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class IdUnicoValidador implements ConstraintValidator<IdUnico, String> {
	
	private String domainAttribute;
	private Class<?> klass;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void initialize(IdUnico params) {
		domainAttribute = params.fieldName();
		klass = params.domainClass();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		
		//Aceita valor Null, pois tem validador EstadoPais, qdo NUll sig Pais não tem estado
		if(value == null) {
			return true;
		}
		
		Query query = entityManager.createQuery("select 1 from "+klass.getName()+" where "+domainAttribute+"=:value");
		query.setParameter("value", value);	


		List<?> list = query.getResultList();
		Assert.isTrue(list.size() <=1, "aconteceu algo bizarro e você tem mais de um "+klass+" com o atributo "+domainAttribute+" com o valor = "+value);

		return !list.isEmpty();
	}
	
}
