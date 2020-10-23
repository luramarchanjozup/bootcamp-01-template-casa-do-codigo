package com.guiferrini.CasaCodigo.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//@Services - esteriotipo
@Component
public class CategoriaDuplicadoValidador implements Validator {
	
	@PersistenceContext 
	EntityManager entityManager;

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaDTO.class.isAssignableFrom(clazz);
	}

	
	@Override
	public void validate(Object target, Errors errors) {
		//1
		if(errors.hasErrors()) {
			return;
		}
		//1
		CategoriaDTO categoriaDTO = (CategoriaDTO) target;
		
		TypedQuery<String> consulta = entityManager.createQuery(
				"SELECT nome " + 
				"FROM Categoria " + 
				"WHERE nome=nome",
				String.class
				);
		List<String> list = consulta.getResultList();
		//1
		if(list.contains(categoriaDTO.getNome())) {
			errors.rejectValue("nome", null,
					"Já existe um(a) outro(a) Categoria(a) com o mesmo nome "
							+ categoriaDTO.getNome());
		}
	}
}
