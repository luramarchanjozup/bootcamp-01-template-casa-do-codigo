package br.com.zup.casadocodigo.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.autor.Autor;
import br.com.zup.casadocodigo.autor.AutorDTO;

@Component
public class ValidaEmailDuplicadoAutor implements Validator {

	@PersistenceContext
	private EntityManager bancoDados;

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		AutorDTO autorDto = (AutorDTO) target;

		List<Autor> emailEncontrado = bancoDados
				.createQuery("SELECT a FROM Autor a WHERE a.email = :email", Autor.class)
				.setParameter("email", autorDto.getEmail()).getResultList();

		if (emailEncontrado.isEmpty() == false) {
			errors.rejectValue("email", "autorDto.email.sendo-usado",
					"Já existe um(a) outro(a) autor(a) com o mesmo email" + autorDto.getEmail());
		}

	}

}
