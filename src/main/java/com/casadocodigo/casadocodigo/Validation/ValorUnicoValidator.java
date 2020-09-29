package com.casadocodigo.casadocodigo.Validation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValorUnicoValidator implements ConstraintValidator<ValorUnico, String> {

	@PersistenceContext
	private EntityManager manager;

	private Class<?> classe;
	private String campo;

	@Override
	public void initialize(ValorUnico parametros) {
		classe = parametros.classe();
		campo = parametros.campo();
	}

	@Override
	@Transactional
	public boolean isValid(String valor, ConstraintValidatorContext constraintValidatorContext) {
		if (valor == null) {
			return false;
		}
		Query query = manager.createQuery("select 1 from " + classe.getName() + " where " + campo + " = :valor");
		query.setParameter("valor", valor);
		List<?> list = query.getResultList();
		return list.isEmpty();
	}
}