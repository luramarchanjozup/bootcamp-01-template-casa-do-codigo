package bootcamp.challenges.casadocodigo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

// Total Intrinsic Load Points: 0?
@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotBlank
    private String code;
    @Positive
    @NotNull
    private Integer percentage;
    @NotNull
    @Future
    private LocalDate expiresOn;
    @Deprecated
    public Coupon() {}

    public Coupon(@NotBlank String code, @Positive @NotNull Integer percentage, @NotNull @Future LocalDate expiresOn) {
        this.code = code;
        this.percentage = percentage;
        this.expiresOn = expiresOn;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", percentage=" + percentage +
                ", expiresOn=" + expiresOn +
                '}';
    }
    @JsonIgnore
    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Integer getPercentage() {
        return percentage;
    }
    @JsonIgnore
    public LocalDate getExpiresOn() {
        return expiresOn;
    }
}
