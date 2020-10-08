package br.com.zup.bootcamp.domain.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

// Intrinsic charge = 1
@Entity
public class Coupon implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false)
    private String id;

    @Column(unique = true, nullable = false)
    private String code;

    @Min(1)
    @Max(100)
    @Positive
    @Column(nullable = false)
    private Integer percentage;

    @Future
    @Column(nullable = false)
    private LocalDate expirationDate;

    @OneToMany(mappedBy = "coupon")
    private Collection<Purchase> purchases;

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setId(String id) {
        this.id = id;
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

    public boolean isExpired() {
        return this.expirationDate != null && this.expirationDate.isBefore(LocalDate.now());
    }
}
