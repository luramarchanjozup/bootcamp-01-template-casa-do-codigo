package br.com.zup.casadocodigo.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
public class ApplyingCoupon {

    @ManyToOne
    private Coupon coupon;

    @Positive
    @NotNull
    private BigDecimal discountPercentage;

    @NotNull @Future
    private LocalDate momentValidity;

    @Deprecated
    public ApplyingCoupon() {
    }

    public ApplyingCoupon(Coupon coupon) {
        this.coupon = coupon;
        this.discountPercentage = coupon.getPercentage();
        this.momentValidity = coupon.getExpirationDate();
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public LocalDate getMomentValidity() {
        return momentValidity;
    }

    public void setMomentValidity(LocalDate momentValidity) {
        this.momentValidity = momentValidity;
    }
}
