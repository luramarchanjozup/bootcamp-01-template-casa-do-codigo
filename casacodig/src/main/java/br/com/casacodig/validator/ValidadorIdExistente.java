package br.com.casacodig.validator;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class ValidadorIdExistente implements ConstraintValidator<IdExistente, Long>{

	private String atributo;
	private String classe;
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void initialize(IdExistente params) {
		atributo = params.campo();
		classe = params.classe();
	}

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		//Query query = manager.createQuery("select 1 from "+classe.getName()+" where "+atributo+"=:value");
		//Query query = manager.createQuery("select 1 from "+classe.getName()+" where id =:value");
		//query.setParameter("value", value);	
		//Funcionou
		//Query query = manager.createQuery("select 1 from Autor where email = 'gabriel@gmail.com'");
		Query query = manager.createQuery("select 1 from "+classe+" where "+atributo+"=:value");
		query.setParameter("value", value);
		
		List<?> list = query.getResultList();
		//Object resultado = query.getSingleResult();
		//System.out.println("-------------TESTE------------------");
		//System.out.println(list);
		//System.out.println(classe);
		
		if (list.size() >= 1) {
			//System.out.println("RESULTADO NAO NULO");
			return true;
		}
		
		//Assert.isTrue(list.size() <=1, "aconteceu algo bizarro e você tem mais de um "+classe+" com o atributo "+atributo+" com o valor = "+value);
		return false;
		//return !list.isEmpty();
	}


}
