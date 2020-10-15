package br.com.zup.casadocodigo.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class UnicoValidador implements ConstraintValidator<ValorUnico, Object> {

	private String atributoDomonio;
	private Class<?> klass;
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void initialize (ValorUnico parametro) {
		atributoDomonio = parametro.nomeCampo();
		klass = parametro.classeDominio();
		
	}
		

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = manager.createQuery("select 1 from "+klass.getName()+ " where "+atributoDomonio+"=: value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		Assert.state(list.size() <=1, "Foi encontrado mais de um "+klass+" com o atributo "+atributoDomonio+"=: value");
		
		return list.isEmpty();
	}

}
