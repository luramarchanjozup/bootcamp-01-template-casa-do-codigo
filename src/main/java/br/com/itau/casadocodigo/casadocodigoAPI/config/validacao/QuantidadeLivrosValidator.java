package br.com.itau.casadocodigo.casadocodigoAPI.config.validacao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.anotacoes.QuantidadeLivros;
import br.com.itau.casadocodigo.casadocodigoAPI.controller.form.CarrinhoComprasForm;
import br.com.itau.casadocodigo.casadocodigoAPI.controller.form.ItemForm;

public class QuantidadeLivrosValidator implements ConstraintValidator<QuantidadeLivros, Object> {

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {

		// 1
		CarrinhoComprasForm carrinhoComprasForm = (CarrinhoComprasForm) value;

		int totalCalculadoServidor = 0;

		// 1 //1
		for (ItemForm item : carrinhoComprasForm.getItens()) {
			totalCalculadoServidor += item.getQuantidade();
		}

		return carrinhoComprasForm.getTotal().intValue() == totalCalculadoServidor;
	}

}
