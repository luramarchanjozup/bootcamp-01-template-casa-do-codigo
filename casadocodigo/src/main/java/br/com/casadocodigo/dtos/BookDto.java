package br.com.casadocodigo.dtos;

import br.com.casadocodigo.models.Book;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class BookDto {

    private String title;
    private String summary;
    private Double price;
    private Long pages;

    public BookDto(Book book) {
        this.title = book.getTitle();
        this.summary = book.getSummary();
        this.price = book.getPrice();
        this.pages = book.getPages();
    }

}
