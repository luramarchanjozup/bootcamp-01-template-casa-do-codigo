package com.apicasadocodigo.casadocodigo.model.purchase;

import com.apicasadocodigo.casadocodigo.model.Address;
import com.apicasadocodigo.casadocodigo.model.Book;
import com.apicasadocodigo.casadocodigo.model.Client;
import com.apicasadocodigo.casadocodigo.model.Coupon;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Client client;

    @NotNull
    @Positive
    private BigDecimal purchaseValue;

    @ManyToOne
    private Coupon coupon;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "pruchase_book",
                joinColumns = @JoinColumn(name = "purchase_id"),
                inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;

    @Deprecated
    public Purchase() { }

    //Uma compra pode ser feita com ou sem cupon, por isso dois construtores (um com cupom e outro sem)
    public Purchase(@NotNull Client client, BigDecimal total, @NotNull @NotEmpty List<Book> books) {
        this.client = client;
        this.books = books;
        this.purchaseValue =  total;
    }

    /*Na classe request posso fazer com que seja feita a busca do cupom e injetar o resultado da busca via construtor
    , a mesma lógica para lista de livros, busco cada uma partir do id e na request faço um Map de Item.idDoLivro para
      livro usando o GenericDao.
     *
     De posse do carrinho de compras posso injetar o valor total no construtor da compra
     *
     O método calculePurchaseValueWithDiscountCoupon(BigDecimal total, BigDecimal couponDiscontValue) é chamado
     apenas no segundo construtor para saber quanto fica o compra com o valor de desconto.
     */

    public Purchase(@NotNull Client client, BigDecimal total, List<Book> books, @NotNull @NotEmpty Coupon coupon) {
        this.client = client;
        this.books = books;
        this.coupon = coupon;
        this.purchaseValue = calculePurchaseValueWithDiscountCoupon(total, coupon.getDiscountValue());
    }

    private BigDecimal calculePurchaseValueWithDiscountCoupon(BigDecimal total, BigDecimal couponDiscontValue){

        /*EXEMPLO: COMPRA NO VALOR DE R$ 90.00 COM DESCONTO DE 10%
        * R: 90 - (10/100 * 90) = R$ 81.00 */

        BigDecimal percentValue = couponDiscontValue.divide(BigDecimal.valueOf(100.00));

        return total.subtract(percentValue.multiply(total));
    }

    public Long getId() {
        return id;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public String getClientEmailFromThisPurchase(){
        return this.client.getEmail();
    }

    public Address getAddressInfo(){
        return this.client.getAddress();
    }

    public BigDecimal getTotal(){
        return this.purchaseValue;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(id, purchase.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
