package br.com.zup.casadocodigo.categoria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
// 4
public class ValidaNomeCategoria implements Validator {
	@PersistenceContext
	private EntityManager bancoDados;

	@Override
	// 1
	public boolean supports(Class<?> clazz) {
		return CategoriaDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// 1
		if (errors.hasErrors()) {
			return;
		}
		CategoriaDTO categoriaDto = (CategoriaDTO) target;
		// 1
		List<Categoria> nomeEncontrado = bancoDados
				.createQuery("SELECT c FROM Categoria c WHERE c.nome = :nome", Categoria.class)
				.setParameter("nome", categoriaDto.getNome()).getResultList();

		// 1
		if (nomeEncontrado.isEmpty() == false) {
			errors.rejectValue("nome", "categoriaDto.nome.sendo-usado",
					"Já existe uma outra categoria com o mesmo nome" + categoriaDto.getNome());
		}

	}

}
