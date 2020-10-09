package br.com.itau.casadocodigo.casadocodigoAPI.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.anotacoes.CupomUtilizavel;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Cupom;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Livro;
import br.com.itau.casadocodigo.casadocodigoAPI.repository.CupomRepository;
import br.com.itau.casadocodigo.casadocodigoAPI.repository.LivroRepository;

public class CarrinhoComprasForm {

	@Min(value = 1, message = "É necessário inserir pelo menos 1 item no carrinho!")
	private BigDecimal total;
	// 1
	@CupomUtilizavel
	private String cupom;
	@Valid
	@Size(min = 1, message = "É necessário inserir pelo menos 1 item no carrinho!")
	// 1
	private List<ItemForm> itens;

	// 1 // 1
	public Map<String, BigDecimal> verificaDesconto(EntityManager entityManager) {

		BigDecimal valorTotalSemDesconto = new BigDecimal(0);
		BigDecimal valorTotalComDesconto = new BigDecimal(0);

		Map<String, BigDecimal> valorAPagar = new HashMap<>();

		// 1
		for (ItemForm item : this.itens) {
			// 1
			Livro livro = (Livro) entityManager.createQuery("select l from Livro l where l.id = ?1")
					.setParameter(1, item.getIdLivro()).getResultList().get(0);

			valorTotalSemDesconto = valorTotalSemDesconto
					.add(livro.getPreco().multiply(new BigDecimal(item.getQuantidade())));
		}

		// 1
		if (this.cupom.length() > 0) {

			// 1
			Cupom cupom = (Cupom) entityManager.createQuery("select c from Cupom c where c.codigo = ?1")
					.setParameter(1, this.cupom).getResultList().get(0);

			valorTotalComDesconto = valorTotalComDesconto.add(valorTotalSemDesconto
					.multiply(new BigDecimal(cupom.getPercentualDesconto() - 1).multiply(new BigDecimal(-1))));

			cupom.setDataUtilizado(LocalDate.now());

			entityManager.persist(cupom);

			valorAPagar.put("ValorComDesconto", valorTotalComDesconto);

		}

		valorAPagar.put("ValorSemDesconto", valorTotalSemDesconto);

		return valorAPagar;

	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<ItemForm> getItens() {
		return itens;
	}

	public void setItens(List<ItemForm> itens) {
		this.itens = itens;
	}

	public String getCupom() {
		return cupom;
	}

	public void setCupom(String cupom) {
		this.cupom = cupom;
	}

}
