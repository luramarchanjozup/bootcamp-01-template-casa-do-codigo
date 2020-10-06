package br.com.zup.bootcamp.domain.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

// Intrinsic charge = 2
@Entity
public class Item implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(nullable = false)
    private int amount;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "isbn", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "purchase_id", referencedColumnName = "id", nullable = false)
    private Purchase purchase;

    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public Book getBook() {
        return book;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
