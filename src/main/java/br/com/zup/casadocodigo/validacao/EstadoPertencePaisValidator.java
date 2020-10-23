package br.com.zup.casadocodigo.validacao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.novacompra.NovaCompraDTO;
import br.com.zup.casadocodigo.paisestado.Estado;
import br.com.zup.casadocodigo.paisestado.Pais;

//9
@Component
public class EstadoPertencePaisValidator implements Validator {

	@PersistenceContext
	private EntityManager bancoDados;

	@Override
	public boolean supports(Class<?> clazz) {
		// 1
		return NovaCompraDTO.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {

		// 1
		// 1
		if (errors.hasErrors()) {

			return;
		}

		NovaCompraDTO request = (NovaCompraDTO) target;
		// 1
		if (request.temEstado()) {
			// 1
			// 1
			Pais pais = bancoDados.find(Pais.class, request.getIdPais());

			// 1
			// 1
			Estado estado = bancoDados.find(Estado.class, request.getIdEstado());

			// 1
			if (estado.naoPertenceAPais(pais)) {
				errors.reject("idEstado", null, "este estado não é o país selecionado");

			}
		}

	}

}