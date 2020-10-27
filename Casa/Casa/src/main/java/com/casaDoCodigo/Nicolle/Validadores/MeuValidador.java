package com.casaDoCodigo.Nicolle.Validadores;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.util.List;


public class MeuValidador implements ConstraintValidator<MinhaAnotacao, String> {
	
	private String nomeCampo;
    Class<?> dominioClasse;
    
    @PersistenceContext
    private EntityManager manager;
    
    @Override
    public void initialize(MinhaAnotacao constraintAnnotation) {
        nomeCampo = constraintAnnotation.nomeCampo();
        dominioClasse = constraintAnnotation.dominioClasse();
    }
    

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		 if (value == null) {
	            return false;
	        }
	        
	        Query query = manager.createQuery("select 1 from "+dominioClasse.getName()+" where "+nomeCampo+"=:value");
	        query.setParameter("value", value);
	        List<?> list = query.getResultList();
	        
	        return list.isEmpty();	        
	}
}
