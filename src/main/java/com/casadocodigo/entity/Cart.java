package com.casadocodigo.entity;

import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@OneToOne
	@Valid
	private Purchase purchase;

	@OneToMany(cascade= CascadeType.PERSIST)
	@JoinColumn(name = "cart_id")
	//@ElementCollection
	@Size(min = 1)
	private Set<ItemCart> itensCart = new HashSet<>();

	@Deprecated
	public Cart (){

	}
	public Cart(@Valid Purchase purchase, @Size(min = 1) Set<ItemCart> itensCart) {
		Assert.isTrue(!itensCart.isEmpty(),	"O pedido deve ter ao menos 1 item");
		this.purchase = purchase;
		this.itensCart.addAll(itensCart);
	}

	public Set<ItemCart> getItensCart() {
		return itensCart;
	}

	@Override
	public String toString() {
		return "Cart [itensCart=" + itensCart + "]";
	}

	public boolean totalIsEqual(@Positive @NotNull BigDecimal total) {
		BigDecimal totalCart = itensCart.stream().map(ItemCart::total).reduce(BigDecimal.ZERO,
				(current, next) -> current.add(next));
		return totalCart.doubleValue() == total.doubleValue();
	}

	public BigDecimal getTotal (){
		BigDecimal totalCart = itensCart.stream().map(ItemCart::total).reduce(BigDecimal.ZERO,
				(current, next) -> current.add(next));
		return totalCart;
	}

	public double getTotalWithDiscount(){
		CouponApplied couponApplied = purchase.getCouponApplied();
		BigDecimal totalCart = this.getTotal();

		if( couponApplied != null) {
			double totalWithDicount = totalCart.subtract(totalCart.multiply(couponApplied.getDescount())).doubleValue();
			return totalWithDicount;
		}
		return totalCart.doubleValue();
	}

}
