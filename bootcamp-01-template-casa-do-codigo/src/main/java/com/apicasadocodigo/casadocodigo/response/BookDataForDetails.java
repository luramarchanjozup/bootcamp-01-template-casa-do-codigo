package com.apicasadocodigo.casadocodigo.response;

import com.apicasadocodigo.casadocodigo.model.Book;

public class BookDataForDetails {

    public String bookName;
    private String priceFormated;

    public BookDataForDetails(Book book) {
        this.bookName = book.getTitle();
        this.priceFormated = String.format("R$ %s", book.getPrice());
    }

    public String getBookName() {
        return bookName;
    }

    public String getPriceFormated() { return priceFormated;
    }
}
