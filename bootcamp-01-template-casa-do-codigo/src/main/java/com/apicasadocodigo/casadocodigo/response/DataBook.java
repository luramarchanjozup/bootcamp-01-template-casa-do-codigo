package com.apicasadocodigo.casadocodigo.response;

public class DataBook {

    private int pageQuantity;
    private String isbn;

    public DataBook(int pageQuantity, String isbn) {
        this.pageQuantity = pageQuantity;
        this.isbn = isbn;
    }

    public int getPageQuantity() {
        return pageQuantity;
    }

    public void setPageQuantity(int pageQuantity) {
        this.pageQuantity = pageQuantity;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
