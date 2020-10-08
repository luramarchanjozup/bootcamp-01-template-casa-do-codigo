package com.casadocodigo.requests;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.casadocodigo.annotations.ExistsValue;
import com.casadocodigo.annotations.UniqueValue;
import com.casadocodigo.entity.Author;
import com.casadocodigo.entity.Book;
import com.casadocodigo.entity.Categories;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class BookRequest {

	@NotBlank
	@UniqueValue(domainClass = Book.class, fieldName = "title", message = "título deve ser único")
	private String title;

	@NotBlank
	@Size(max = 500)
	private String summary;

	private String abstractBook;

	@NotNull
	@Min(20)
	private BigDecimal price;

	@Min(100)
	private int numberOfPages;

	@NotBlank
	@UniqueValue(domainClass = Book.class, fieldName = "isbn", message = "isbn deve ser único")
	private String isbn;

	@Future
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate publishDate;
	
	@NotNull
	@ExistsValue(domainClass = Categories.class, fieldName = "id", message = "A categoria deve existir")
	private Long idCategory;
	
	@NotNull
	@ExistsValue(domainClass = Author.class, fieldName = "id", message = "O Autor deve existir")
	private Long idAuthor;

	public BookRequest(@NotBlank String title, @NotBlank @Size(max = 500) String summary, String abstractBook,
			@NotNull @Min(20) BigDecimal price, @Min(100) int numberOfPages, @NotBlank String isbn,
			@NotNull Long idCategory, @NotNull Long idAuthor) {
		super();
		this.title = title;
		this.summary = summary;
		this.abstractBook = abstractBook;
		this.price = price;
		this.numberOfPages = numberOfPages;
		this.isbn = isbn;
		this.idCategory = idCategory;
		this.idAuthor = idAuthor;
	}

	public Book toModel(EntityManager manager) {
		@NotNull
		Author author = manager.find(Author.class, idAuthor);
		@NotNull
		Categories category = manager.find(Categories.class, idCategory);
		
		Assert.state(author!=null, "O Autor precisa estar cadastrado "+idAuthor);
		Assert.state(category!=null, "A categoria precisa estar cadastada "+idCategory);
		
		return new Book(title, summary, abstractBook, price, numberOfPages, isbn, publishDate, author, category);
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

}
