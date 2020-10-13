package com.casadocodigo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotBlank
	private String title;

	@NotBlank
	@Size(max = 500)
	private String summary;

	private String abstractBook;

	@NotNull
	@Min(20)
	@Positive
	private BigDecimal price;

	@NotNull
	@Min(100)
	private Integer numberOfPages;

	@NotNull
	private String isbn;

	@Future
	@NotNull
	private LocalDate publishDate;
	
	@ManyToOne
	@NotNull
	@Valid
	private Author author;
	
	@ManyToOne
	@NotNull
	@Valid
	private Categories categorie;

	@Deprecated
	public Book() {

	}

	public Book(@NotBlank String title, @NotBlank @Size(max = 500) String summary, String abstractBook,
			@NotNull @Min(20) BigDecimal price, @NotNull @Min(100) Integer numberOfPages, @NotNull String isbn,
			@Future @NotNull LocalDate publishDate, @NotNull @Valid Author author,
			@NotNull @Valid Categories categorie) {
		super();
		this.title = title;
		this.summary = summary;
		this.abstractBook = abstractBook;
		this.price = price;
		this.numberOfPages = numberOfPages;
		this.isbn = isbn;
		this.publishDate = publishDate;
		this.author = author;
		this.categorie = categorie;
	}
	

	public @Positive BigDecimal getPrice() {
		return price;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getSummary() {
		return summary;
	}

	public String getAbstractBook() {
		return abstractBook;
	}

	public Integer getNumberOfPages() {
		return numberOfPages;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public Author getAuthor() {
		return author;
	}

	public Categories getCategorie() {
		return categorie;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", summary=" + summary + ", abstractBook="
				+ abstractBook + ", price=" + price + ", numberOfPages=" + numberOfPages + ", isbn=" + isbn
				+ ", publishDate=" + publishDate + ", author=" + author + ", categorie=" + categorie + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
