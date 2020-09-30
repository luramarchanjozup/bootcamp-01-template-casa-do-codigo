package br.com.casadocodigo.dtos;

import br.com.casadocodigo.models.Book;
import br.com.casadocodigo.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

    private Double total;

    private List<BookDto> booksDtos;

    public UserDto(User user){
        this.total = user.getTotal();
        this.booksDtos = toDto(user.getShoppingCart());
    }

    public List<BookDto> toDto(List<Book> books){

        List<BookDto> dtos = new ArrayList<>();

        books.forEach(book -> {
            BookDto bookdto = new BookDto(book);
            dtos.add(bookdto);
        });

        return dtos;

    }


}
