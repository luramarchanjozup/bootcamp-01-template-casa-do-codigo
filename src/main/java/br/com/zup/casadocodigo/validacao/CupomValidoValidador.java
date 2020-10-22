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

@Component
public class CupomValidoValidador implements Validator {

	@PersistenceContext
	private EntityManager bancoDados;

	private Cupom cupomValido;

	@Override
	public boolean supports(Class<?> clazz) {
		return NovaCompraDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (errors.hasErrors()) {

			return;
		}

		NovaCompraDTO request = (NovaCompraDTO) target;
		Optional<String> possivelCodigo = request.getCodigoCupom();
		cupomValido = new Cupom();
		if (possivelCodigo.isPresent()) {

			List<Cupom> cupom = bancoDados.createQuery("SELECT c FROM Cupom c WHERE c.codigo = :codigo", Cupom.class)
					.setParameter("codigo", possivelCodigo.get()).getResultList();

			if (!cupom.isEmpty()) {
				cupomValido = cupom.stream().findFirst().get();
			}

			if (!cupomValido.valido()) {
				errors.rejectValue("codigoCupom", null, "Este cupom não é mais válido");
			}

		}
	}

}
