package br.com.zup.casadocodigo.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

//4
@Component
public class UnicoValidador implements ConstraintValidator<ValorUnico, Object> {
//1
	private String atributoDomonio;
	private Class<?> klass;

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void initialize(ValorUnico parametro) {
		atributoDomonio = parametro.nomeCampo();
		klass = parametro.classeDominio();

	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = manager
//1
//1
				.createQuery("select 1 from " + klass.getName() + " where " + atributoDomonio + "=: value");
		query.setParameter("value", value);

		List<?> list = query.getResultList();
//1
		Assert.state(list.size() <= 1,
				"Foi encontrado mais de um " + klass + " com o atributo " + atributoDomonio + "=: value");

		return list.isEmpty();
	}

}
