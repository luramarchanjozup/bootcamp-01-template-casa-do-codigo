package br.com.casadocodigo.forms;

import br.com.casadocodigo.models.Book;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class BookForm {

    private String title;
    private String resume;
    private String summary;
    private Double price;
    private Long pages;
    private Long Isbn;

    public Book toEntity(){

        return new Book(title,resume,summary,price,pages,Isbn);

    }

    public BookForm(String title, String resume, String summary, Double price, Long pages, Long isbn) {
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.pages = pages;
        Isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public void setIsbn(Long isbn) {
        Isbn = isbn;
    }
}
