package com.casadocodigo.requests;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.casadocodigo.annotations.ExistsValue;
import com.casadocodigo.entity.Book;
import com.casadocodigo.entity.ItemCart;

public class ItemCartRequest {

	@NotNull
	@ExistsValue(domainClass = Book.class, fieldName = "id")
	private Long idBook;
	
	@Positive
	private int quantity;

	public ItemCartRequest(@NotNull Long idBook, @Positive int quantity) {
		super();
		this.idBook = idBook;
		this.quantity = quantity;
	}
	
	public Long getIdBook() {
		return idBook;
	}

	@Override
	public String toString() {
		return "ItemCartRequest [idBook=" + idBook + ", quantity=" + quantity + "]";
	}
	
	
	public ItemCart toModel(EntityManager manager) {
		@NotNull
		Book book = manager.find(Book.class, idBook);
		return new ItemCart(book,quantity);
	}

}
