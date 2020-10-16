package br.com.zup.casadocodigo.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class ValidaIdExistente implements ConstraintValidator<IdExiste, Object> {

	private String domainAttibute;
	
	private Class<?> klass;
	
	@PersistenceContext
	private EntityManager dadosId;
	
	@Override
	public void initialize(IdExiste parametro) {
		domainAttibute = parametro.fieldName();
		klass = parametro.domainClass();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
			Query query = dadosId.createQuery("select 1 from "+klass.getName()+ " where " +domainAttibute+"=:value");
			query.setParameter("value", value);
			
			
			List<?> lista = query.getResultList();
			Assert.isTrue(lista.size()<=1, "Id já cadastrado "+klass+" com o atributo "+domainAttibute+" com valor = "+value);
	
			return !lista.isEmpty();
	}

	
	
	
	
}
