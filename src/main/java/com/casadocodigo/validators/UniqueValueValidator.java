package com.casadocodigo.validators;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

import com.casadocodigo.annotations.UniqueValue;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

	private String atribute;
	private Class<?> theClass;

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void initialize(UniqueValue value) {
		atribute = value.fieldName();
		theClass = value.domainClass();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {

		Query query = entityManager.createQuery("select 1 from " + theClass.getName() + " where " + atribute + " =:value");
		query.setParameter("value", value);

		List<?> list = query.getResultList();
		Assert.state(list.size() <= 1, "já existe um elemento " + theClass + " com atributo o " + atribute + "=" + value);

		return list.isEmpty();
	}
	
}
