package com.casadocodigo.entity;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

//@Embeddable
@Entity
public class ItemCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@NotNull
	private Book book;

	@Positive
	private Integer quantity;
	
	@Positive
	private BigDecimal price;

	@Deprecated
	public ItemCart() {
		
	}

	public ItemCart(@NotNull Book book, @Positive Integer quantity) {
		this.book = book;
		this.quantity = quantity;
		this.price = book.getPrice();
	}
	
	public BigDecimal total() {
		return price.multiply(new BigDecimal(quantity));
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "ItemCart [book=" + book + ", quantity=" + quantity + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCart other = (ItemCart) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		return true;
	}


}
