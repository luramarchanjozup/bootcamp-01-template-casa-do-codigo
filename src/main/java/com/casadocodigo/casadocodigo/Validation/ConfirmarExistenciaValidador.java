package com.casadocodigo.casadocodigo.Validation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmarExistenciaValidador implements ConstraintValidator<ConfirmarExistencia, Long> {
	
	private String campo;
	private Class<?> classe;
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void initialize(ConfirmarExistencia params) {
		campo = params.campo();
		classe = params.classe();
}
	
	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		Query query = manager.createQuery("select 1 from "+classe.getName()+" where "+campo+"=:value");
		query.setParameter("value", value);	
		List<?> list = query.getResultList();		

		return !list.isEmpty();
	}
	
	
	
}
