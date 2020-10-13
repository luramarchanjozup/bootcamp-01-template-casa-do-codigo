package com.casadocodigo.responses;

import com.casadocodigo.entity.Book;
import com.casadocodigo.entity.ItemCart;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BooksResponse {

    private List<?> books = new ArrayList<>();

    public BooksResponse(List<?> listBook) {
        books = listBook;
    }

    public List<?> getBooks() {
        return books;
    }
}
