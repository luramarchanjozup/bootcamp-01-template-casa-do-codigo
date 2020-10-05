package br.com.casadocodigo.services;

import br.com.casadocodigo.models.Book;
import br.com.casadocodigo.models.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class AddToCartService {

    @Autowired
    private EntityManager entityManager;

    //+1
    @Transactional               //+1        //+1
    public Shop addToCart(Long bookId, Long shopId){

        //+1
        Book book = entityManager.find(Book.class, bookId);

        //+1
        Shop shop = entityManager.find(Shop.class, shopId);

        //+1
        List<Book> books = shop.getShoppingCart();

        //+1
        Double newTotal = shop.getTotal() + book.getPrice();

        //+1
        books.add(book);

        //+1
        shop.setShoppingCart(books);

        //+1
        shop.setTotal(newTotal);

        entityManager.persist(shop);

        return shop;

    }
}
