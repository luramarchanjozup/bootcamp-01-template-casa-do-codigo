package br.com.casadocodigo.dtos;

import br.com.casadocodigo.models.Book;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class BookDto {

    private String title;
    private Double price;

    public BookDto(Book book) {
        this.title = book.getTitle();
        this.price = book.getPrice();
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

}
