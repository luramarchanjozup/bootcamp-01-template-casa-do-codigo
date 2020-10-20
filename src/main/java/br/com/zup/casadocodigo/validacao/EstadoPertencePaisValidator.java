package br.com.zup.casadocodigo.validacao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.novacompra.NovaCompraDTO;
import br.com.zup.casadocodigo.paisestado.Estado;
import br.com.zup.casadocodigo.paisestado.Pais;

@Component
public class EstadoPertencePaisValidator implements Validator {

	@PersistenceContext
	private EntityManager bancoDados;

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

		if (request.temEstado()) {
			Pais pais = bancoDados.find(Pais.class, request.getIdPais());
			Estado estado = bancoDados.find(Estado.class, request.getIdEstado());

			if (estado.naoPertenceAPais(pais)) {
				errors.reject("idEstado", null, "este estado não é o país selecionado");

			}
		}

	}

}