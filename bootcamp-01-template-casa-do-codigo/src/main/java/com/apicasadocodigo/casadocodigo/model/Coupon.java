package com.apicasadocodigo.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotNull
    private String cod;

    @NotNull
    @Positive
    private BigDecimal discountValue;

    @NotNull
    @FutureOrPresent
    private LocalDate validate;

    @Deprecated
    public Coupon() { }

    public Coupon(@NotEmpty @NotNull String cod, @NotEmpty @NotNull @Positive BigDecimal discountValue,
                  @Future @NotNull LocalDate validate) {

        this.cod = cod;
        this.discountValue = discountValue;
        this.validate = validate;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public String getCod() {
        return cod;
    }

    public LocalDate getValidate() {
        return validate;
    }

    private void setCod(String cod) {
        this.cod = cod;
    }

    private void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    private void setValidate(LocalDate validate) {
        this.validate = validate;
    }

    public void setProperties(String cod, BigDecimal discountValue, LocalDate validateDate) {
        this.setCod(cod);
        this.setDiscountValue(discountValue);
        this.setValidate(validateDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coupon that = (Coupon) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
