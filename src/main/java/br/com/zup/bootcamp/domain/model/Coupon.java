package br.com.zup.bootcamp.domain.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;

// Intrinsic charge = 0
@Entity
public class Coupon implements Serializable {

    @Id
    @NaturalId
    private String code;

    @NotNull
    @Positive
    private Integer percentage;

    @Column(nullable = false)
    private LocalDate expirationDate;

    public String getCode() {
        return code;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
