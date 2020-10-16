package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.annotations.ExistsValue;
import br.com.zup.casadocodigo.annotations.UniqueValue;
import br.com.zup.casadocodigo.domain.*;
import br.com.zup.casadocodigo.repository.CouponRepository;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.function.Function;

@Getter
@Setter
public class BuyerDTO {

    @NotBlank(message = "is required")
    private String name;

    @NotBlank(message = "is required")
    private String surname;

    @NotBlank(message = "is required") @Email(message = "Invalid email address")
    @UniqueValue(domainClass = Buyer.class, fieldName = "email", message = "already registered")
    private String email;

    @NotBlank(message = "is required")
    private String cpfCnpj;

    @NotBlank(message = "is required")
    private String address;

    @NotBlank(message = "is required")
    private String complement;

    @NotBlank(message = "is required")
    private String city;

    @NotNull(message = "is required")
    @ExistsValue(domainClass = Country.class, fieldName = "id", message = "the country does not exist")
    private Long countryId;

    //@NotBlank(message = "is required")
    @ExistsValue(domainClass = State.class, fieldName = "id", message = "the state does not exist")
    private Long stateId;

    @NotBlank(message = "is required")
    private String phone;

    @NotBlank(message = "is required")
    private String zipCode;

    @NotNull @Valid
    private OrderDTO order;

    @ExistsValue(domainClass = Coupon.class,fieldName = "code")
    private String codeCoupon;


    public BuyerDTO(@NotBlank String name, @NotBlank String surname,
                    @NotBlank @Email String email,
                    @NotBlank String cpfCnpj,
                    @NotBlank String address,
                    @NotBlank String complement,
                    @NotBlank String city,
                    @NotNull Long countryId,
                    Long stateId,
                    @NotBlank String phone,
                    @NotBlank String zipCode, @NotNull @Valid OrderDTO order) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.countryId = countryId;
        this.stateId = stateId;
        this.phone = phone;
        this.zipCode = zipCode;
        this.order = order;
    }


    public Long getCountryId() {
        return countryId;
    }

    public Long getStateId() {
        return stateId;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setCodeCoupon(String codeCoupon) {
        this.codeCoupon = codeCoupon;
    }

    public boolean validatesCpfCnpj() {
        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(cpfCnpj, null) || cnpjValidator.isValid(cpfCnpj, null);
    }

    public Buyer toModel(EntityManager manager, CouponRepository couponRepository) {
        Country country = manager.find(Country.class, countryId);

        Function<Buyer, Order> createOrder = order.toModel(manager);

        Buyer buyer = new Buyer(this.name, this.surname, this.email, this.cpfCnpj,
        this.address, this.complement, this.city, country, this.phone, this.zipCode, createOrder);

        if(stateId != null) {
            buyer.setState(manager.find(State.class, stateId));
        }

        if(StringUtils.hasText(codeCoupon)) {
            Coupon coupon = couponRepository.findByCode(codeCoupon);
            buyer.applyCoupon(coupon);
        }

        return buyer;
    }

    public Optional<String> getCodeCoupon() {
        return Optional.ofNullable(codeCoupon);
    }
}
