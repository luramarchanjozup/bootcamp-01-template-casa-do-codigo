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

//7
public class CarrinhoCompraDTO {

	@Positive
	@NotNull
	private BigDecimal total;

	// 1
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

	// 1
	// 1
	public Function<Compra, CarrinhoCompra> geraNovoCarrinho(EntityManager bancoDados) {

		// 1
		List<ItemCarrinho> itensCarrinho = new ArrayList<>();

		// 1
		for (ItemCarrinhoDTO itemCarrinhoDTO : itens) {
			// 1
			itensCarrinho.add(itemCarrinhoDTO.gerarNovoItemCarrinho(bancoDados));
		}

		return (compra) -> {
			CarrinhoCompra pedido = new CarrinhoCompra(compra, itensCarrinho);
			// 1
			Assert.isTrue(pedido.totalIgual(total), "Total enviado não corresponde ao total real");
			return pedido;
		};
	}

}
