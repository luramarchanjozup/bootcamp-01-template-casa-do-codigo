package br.com.casadocodigo.dtos;

import br.com.casadocodigo.models.Book;
import br.com.casadocodigo.models.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopDto {

    private Double total;

    private List<BookDto> booksDtos;

    public ShopDto(Shop shop){

        this.total = shop.getTotal();
        this.booksDtos = toDto(shop.getShoppingCart());

    }

    public List<BookDto> toDto(List<Book> books){

        List<BookDto> dtos = new ArrayList<>();

        books.forEach(book -> {
            BookDto bookdto = new BookDto(book);
            dtos.add(bookdto);
        });

        return dtos;

    }

    public Double getTotal() {
        return total;
    }

    public List<BookDto> getBooksDtos() {
        return booksDtos;
    }
}
