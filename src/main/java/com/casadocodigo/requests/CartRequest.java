package com.casadocodigo.requests;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.casadocodigo.entity.Cart;
import com.casadocodigo.entity.ItemCart;
import com.casadocodigo.entity.Purchase;

public class CartRequest {

	@Positive
	@NotNull
	private BigDecimal total;
	
	@Valid
	@Size(min = 1)
	private List<ItemCartRequest> itens;

	public CartRequest(@Positive @NotNull BigDecimal total, @Valid @Size(min = 1) List<ItemCartRequest> itens) {
		this.total = total;
		this.itens = itens;
	}

	public List<ItemCartRequest> getItens() {
		return itens;
	}

	@Override
	public String toString() {
		return "CartRequest [total=" + total + ", itens=" + itens + "]";
	}

	
	public Function<Purchase,Cart> toModel (EntityManager manager) {

		Set<ItemCart> allItens = itens.stream().map(item -> item.toModel(manager)).collect(Collectors.toSet());
		
		return (shop) -> {
			Cart cart = new Cart(shop, allItens);
			Assert.isTrue(cart.totalIsEqual(total), "O valor enviado está diferente!");
			return cart;
		};
	}


}
