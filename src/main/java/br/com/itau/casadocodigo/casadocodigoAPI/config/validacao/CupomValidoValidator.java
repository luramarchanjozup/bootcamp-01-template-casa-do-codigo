package br.com.itau.casadocodigo.casadocodigoAPI.config.validacao;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.anotacoes.CupomUtilizavel;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Cupom;
import br.com.itau.casadocodigo.casadocodigoAPI.repository.CupomRepository;

public class CupomValidoValidator implements ConstraintValidator<CupomUtilizavel, String> {

	// 1
	@Autowired
	private CupomRepository cupomRepository;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (value.length() == 0)
			return true;

		// 1
		Optional<Cupom> cupom = cupomRepository.findByCodigo((String) value);

		// 1
		if (cupom.isPresent()) {

			LocalDate dataValidade = cupom.get().getDataValidade();
			LocalDate dataUtilizado = cupom.get().getDataUtilizado();

			// 1
			if (dataUtilizado != null || LocalDate.now().isAfter(dataValidade))
				return false;
			// 1
			else
				return true;
			// 1
		} else {
			return false;
		}

	}

}
