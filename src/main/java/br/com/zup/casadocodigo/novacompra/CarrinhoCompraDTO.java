package br.com.zup.casadocodigo.novacompra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

public class CarrinhoCompraDTO {

	@Positive
	@NotNull
	private BigDecimal total;
	@Size(min = 1)
	@Valid
	private List<ItemCarrinhoDTO> itens = new ArrayList<>();

	public CarrinhoCompraDTO(@Positive @NotNull BigDecimal total, @Size(min = 1) @Valid List<ItemCarrinhoDTO> itens) {
		this.total = total;
		this.itens = itens;
	}

	public List<ItemCarrinhoDTO> getItens() {
		return itens;
	}

	public Function<Compra, CarrinhoCompra> geraNovoCarrinho(EntityManager bancoDados) {

		List<ItemCarrinho> itensCarrinho = new ArrayList<>();

		for (ItemCarrinhoDTO itemCarrinhoDTO : itens) {
			itensCarrinho.add(itemCarrinhoDTO.gerarNovoItemCarrinho(bancoDados));
		}

		return (compra) -> {
			CarrinhoCompra pedido = new CarrinhoCompra(compra, itensCarrinho);
			Assert.isTrue(pedido.totalIgual(total), "Total enviado não corresponde ao total real");
			return pedido;
		};
	}

}
