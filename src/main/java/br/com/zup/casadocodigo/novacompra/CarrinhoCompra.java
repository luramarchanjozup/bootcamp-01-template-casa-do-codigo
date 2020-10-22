package br.com.zup.casadocodigo.novacompra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

@Entity
public class CarrinhoCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Valid
	@OneToOne
	private Compra compra;

	@Size(min = 1)
	@ElementCollection
	private List<ItemCarrinho> itens = new ArrayList<>();

	public CarrinhoCompra(@NotNull @Valid Compra compra, @Size(min = 1) List<ItemCarrinho> itens) {
		Assert.isTrue(!itens.isEmpty(), "todo pedido dever ter pelo menos um item");
		this.compra = compra;
		this.itens = itens;
	}

	public boolean totalIgual(@Positive @NotNull BigDecimal total) {
		BigDecimal totalPedido = itens.stream().map(ItemCarrinho::total).reduce(BigDecimal.ZERO,
				(atual, proximo) -> atual.add(proximo));

		return totalPedido.doubleValue() == total.doubleValue();
	}
}
