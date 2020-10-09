package br.com.zup.bootcamp.domain.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

// Intrinsic charge = 6
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

    @Column(nullable = false)
    private float finalPrice;

    @ManyToOne
    @JoinColumn(name = "coupon_id", referencedColumnName = "id")
    private Coupon coupon;

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

    public float getFinalPrice() {
        return finalPrice;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public Coupon getCoupon() {
        return coupon;
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

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public boolean isTotalInvalid() {
        return this.total <= 0;
    }

    public boolean isRequestTotalNotEquals(EntityManager manager) {
        float total = 0;

        for (Item item : items){
            Book book = manager.find(Book.class, item.getBook().getIsbn());
            total += book.getPrice() * item.getAmount();
        }

        return total != this.total;
    }

    public void applyDiscount() {
        if(this.coupon != null) this.finalPrice = this.total - ((this.total * this.coupon.getPercentage()) / 100 );
    }
}
