package br.com.itau.casadocodigo.casadocodigoAPI.config.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

import br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.anotacoes.VerificaExistenciaTuplaRelacao;

public class VerificaExistenciaTuplaRelacaoValidator
		implements ConstraintValidator<VerificaExistenciaTuplaRelacao, Object> {

	private String nomeDominio;
	private Class<?> klass;
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void initialize(VerificaExistenciaTuplaRelacao params) {
		nomeDominio = params.fieldName();
		klass = params.domainClass();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = manager.createQuery("select 1 from " + klass.getName() + " where " + nomeDominio + "=:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();

		return !list.isEmpty();
	}
}
