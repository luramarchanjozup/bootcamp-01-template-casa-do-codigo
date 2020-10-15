package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.annotations.UniqueValue;
import br.com.zup.casadocodigo.domain.Coupon;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter
public class CouponDTO {

    @NotBlank(message = "is required")
    @UniqueValue(domainClass = Coupon.class, fieldName = "code", message = "already registered")
    private String code;

    @NotNull(message = "is required")
    @Positive
    private BigDecimal percentage;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate expirationDate;

    @Deprecated
    public CouponDTO() {
    }

    public CouponDTO(@NotBlank(message = "is required") String code,
                     @NotNull(message = "is required") @Positive BigDecimal percentage,
                     @Future LocalDate expirationDate) {
        this.code = code;
        this.percentage = percentage;
        this.expirationDate = expirationDate;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public Coupon toModel(EntityManager manager) {
        return new Coupon(this.code, this.percentage, this.expirationDate);
    }

    public Coupon toModelSet(Coupon coupon) {
        coupon.setCode(code);
        coupon.setPercentage(percentage);
        coupon.setExpirationDate(expirationDate);
        return coupon;
    }


    public List<Coupon> ValidatesDuplicity(Long id, EntityManager manager){
        List<Coupon> exists = manager.createQuery("SELECT c from coupon c WHERE code=:code AND id !=:id", Coupon.class)
                .setParameter("code", code)
                .setParameter("id", id)
                .getResultList();
        return exists;
    }
}
