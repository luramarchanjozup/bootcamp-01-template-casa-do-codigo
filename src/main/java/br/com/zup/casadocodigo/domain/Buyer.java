package br.com.zup.casadocodigo.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;

@Getter @Setter
@Entity(name = "buyer")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String email;
    private String cpfCnpj;
    private String address;
    private String complement;
    private String city;

    @ManyToOne
    private Country country;

    @ManyToOne
    private State state;

    private String phone;
    private String zipCode;

    @OneToOne(mappedBy = "buyer",cascade = CascadeType.PERSIST)
    private Order order;

    @Embedded
    private ApplyingCoupon applyingCoupon;

    @Deprecated
    public Buyer(){

    }

    public Buyer(@NotBlank String name, @NotBlank String surname,
                    @NotBlank @Email String email, @NotBlank String cpfCnpj,
                    @NotBlank String address, @NotBlank String complement,
                    @NotBlank String city, @NotBlank Country country,
                   // String state,
                    @NotBlank String phone,
                    @NotBlank String zipCode, Function<Buyer, Order> createOrder) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.country = country;
       //this.state = state;
        this.phone = phone;
        this.zipCode = zipCode;
        this.order = createOrder.apply(this);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void applyCoupon (Coupon coupon) {
        Assert.isTrue(coupon.valid(),"the coupon being applied is no longer valid");
        Assert.isNull(applyingCoupon,"cannot exchange a coupon for a purchase");
        this.applyingCoupon = new ApplyingCoupon(coupon);
    }

    public BigDecimal totaldiscount(BigDecimal total){
        var discount = total.multiply(this.applyingCoupon.getDiscountPercentage().divide(BigDecimal.valueOf(100)));
        return (total.subtract(discount)).setScale(2, RoundingMode.HALF_UP);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
