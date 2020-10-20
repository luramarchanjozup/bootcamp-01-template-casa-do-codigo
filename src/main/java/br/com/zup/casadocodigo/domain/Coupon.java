package br.com.zup.casadocodigo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "coupon")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private BigDecimal percentage;

    private LocalDate expirationDate;

    @Deprecated
    public Coupon() {
    }

    public Coupon(@NotBlank String code, @NotNull @Positive BigDecimal percentage, @Future LocalDate expirationDate) {
        this.code = code;
        this.percentage = percentage;
        this.expirationDate = expirationDate;
    }

    public Coupon(Long id, String code, BigDecimal percentage, LocalDate expirationDate) {
        this.id = id;
        this.code = code;
        this.percentage = percentage;
        this.expirationDate = expirationDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getId() {
        return id;
    }

    public boolean valid() {
        return LocalDate.now().compareTo(this.expirationDate) <= 0;
    }



}
