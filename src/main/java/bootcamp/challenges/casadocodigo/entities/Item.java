package bootcamp.challenges.casadocodigo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @OneToOne
    private Book book;
    @NotNull
    @Min(1)
    private int amount;
    @NotNull
    @ManyToOne
    private Billing billing;

    @Deprecated
    public Item() {}

    public Item(@NotNull Book book, @Min(1) int amount) {
        this.book = book;
        this.amount = amount;
    }
    @JsonIgnore
    public Long getId() {
        return id;
    }

    public String getTitle() {
        if (book != null) return book.getTitle();
        return null;
    }

    public BigDecimal getPrice(){
        if (book != null) return book.getPrice();
        return null;
    }

    public int getAmount() {
        return amount;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", book=" + book +
                ", amount=" + amount +
                '}';
    }
}
