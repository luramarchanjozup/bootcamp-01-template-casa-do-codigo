package bootcamp.challenges.casadocodigo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;
// Total Intrinsic Load Points: 3
@Entity
public class Billing {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Digits(integer=6, fraction=2)
    private BigDecimal totalBilling;
    private BigDecimal discount;
    @NotNull
    @Embedded
    private Customer customer; // 1 - Customer
    @NotNull
    @Embedded
    private Order order; // 1 - Order
    @Transient
    private Coupon coupon; // 1 - Coupon
    @Deprecated
    public Billing()  {}

    public Billing(@NotNull Customer customer, @NotNull Order order, Coupon coupon) {
        this.customer = customer;
        this.order = order;
        assignItems();
        this.coupon = coupon;
        this.totalBilling = applyCoupon(coupon);
    }
    @JsonIgnore
    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Order getOrder() {
        return order;
    }

    public BigDecimal getTotalBilling() {
        return totalBilling;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    private void assignItems(){
        if (order != null) {
            order.getItems().forEach(item -> { item.setBilling(this); });
        }
    }

    private BigDecimal applyCoupon(Coupon coupon){
        if (coupon != null) {
            BigDecimal percentage = new BigDecimal(coupon.getPercentage()).divide(new BigDecimal(100));
            BigDecimal discount = order.getTotal().multiply(percentage);
            this.discount = discount;
            return order.getTotal().subtract(discount);
        }
        return order.getTotal();
    }

    @Override
    public String toString() {
        return "Billing{" +
                "id=" + id +
                ", customer=" + customer +
                ", order=" + order +
                ", coupon=" + coupon +
                '}';
    }
}
