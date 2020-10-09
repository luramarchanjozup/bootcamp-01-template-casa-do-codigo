package br.com.casacodig.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;

import org.springframework.util.Assert;

import br.com.casacodig.error.ApiErroException;

public class ValidadorValorUnico implements ConstraintValidator<ValorUnico, Object>{
	

	private String atributo;
	private Class<?> classe;
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void initialize(ValorUnico params) {
		atributo = params.campo();
		classe = params.classe();
	}


	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		//System.out.println("-------------TESTE VALOR UNICO------------------");
		//System.out.println(classe.getName());
		//System.out.println(atributo);
		Query query = manager.createQuery("select 1 from "+classe.getName()+" where "+atributo+"=:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		//System.out.println(list);
		//System.out.println("------------------------------------------------");
		Assert.state(list.size() <=1, "Foi encontrado mais de um "+classe+" com o atributo "+atributo+" = "+value);
		return list.isEmpty();
	}	

}
