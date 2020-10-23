package br.com.zup.casadocodigo.validacao;

//4
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

//1
@Component
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

		// 1
		if (value == null) {
			return true;
		}

		// 1
		Query query = dadosId.createQuery("select 1 from " + klass.getName() + " where " + domainAttibute + "=:value");
		query.setParameter("value", value);

		List<?> lista = query.getResultList();

		// 1
		Assert.isTrue(lista.size() <= 1,
				"Id já cadastrado " + klass + " com o atributo " + domainAttibute + " com valor = " + value);

		return !lista.isEmpty();
	}

}
