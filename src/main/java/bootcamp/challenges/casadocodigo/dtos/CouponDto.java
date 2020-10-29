package bootcamp.challenges.casadocodigo.dtos;

import bootcamp.challenges.casadocodigo.entities.Coupon;
import bootcamp.challenges.casadocodigo.validators.EntityValueExists;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class CouponDto {
    @NotBlank
    @EntityValueExists(entityClass = Coupon.class, entityFieldName = "code", message = "já existe e não pode ser duplicado.")
    private final String code;
    @Positive
    @NotNull
    private final Integer percentage;
    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private final LocalDate expiresOn;

    public CouponDto(@NotBlank String code, @Positive @NotNull Integer percentage, @NotNull @Future LocalDate expiresOn) {
        this.code = code;
        this.percentage = percentage;
        this.expiresOn = expiresOn;
    }

    public String getCode() {
        return code;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public LocalDate getExpiresOn() {
        return expiresOn;
    }

    public Coupon toModel(){
        return new Coupon(code,percentage,expiresOn);
    }

}

