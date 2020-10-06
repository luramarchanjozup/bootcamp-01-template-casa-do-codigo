package br.com.zup.bootcamp.domain.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

// Intrinsic charge = 2
@Entity
public class Purchase implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id", referencedColumnName = "id", nullable = false)
    private Buyer buyer;

    @Column(nullable = false)
    private float total;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
    private Collection<Item> items;

    public String getId() {
        return id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public float getTotal() {
        return total;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    public void addItem(Item item){
        this.items.add(item);
    }
}
