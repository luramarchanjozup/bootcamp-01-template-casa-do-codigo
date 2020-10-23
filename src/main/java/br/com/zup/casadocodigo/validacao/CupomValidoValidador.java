package br.com.zup.casadocodigo.validacao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.cupom.Cupom;
import br.com.zup.casadocodigo.novacompra.NovaCompraDTO;

//7
@Component
public class CupomValidoValidador implements Validator {

	@PersistenceContext
	private EntityManager bancoDados;

	// 1
	private Cupom cupomValido;

	@Override
	public boolean supports(Class<?> clazz) {
		// 1
		return NovaCompraDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		// 1
		if (errors.hasErrors()) {

			return;
		}

		NovaCompraDTO request = (NovaCompraDTO) target;
		Optional<String> possivelCodigo = request.getCodigoCupom();
		cupomValido = new Cupom();
		// 1
		if (possivelCodigo.isPresent()) {

			// 1
			List<Cupom> cupom = bancoDados.createQuery("SELECT c FROM Cupom c WHERE c.codigo = :codigo", Cupom.class)
					.setParameter("codigo", possivelCodigo.get()).getResultList();

			// 1
			if (!cupom.isEmpty()) {
				cupomValido = cupom.stream().findFirst().get();
			}

			// 1
			if (!cupomValido.valido()) {
				errors.rejectValue("codigoCupom", null, "Este cupom não é mais válido");
			}

		}
	}

}
