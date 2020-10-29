package bootcamp.challenges.casadocodigo.dtos;

import bootcamp.challenges.casadocodigo.entities.Billing;
import bootcamp.challenges.casadocodigo.entities.Coupon;
import bootcamp.challenges.casadocodigo.entities.Customer;
import bootcamp.challenges.casadocodigo.entities.Order;
import bootcamp.challenges.casadocodigo.validators.EntityValueExists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

// Total Intrinsic Load Points: 3
@Validated
public final class BillingDto {
    Logger logger = LoggerFactory.getLogger(Coupon.class);
    @NotNull
    private final CustomerDto customerDto;
    @NotNull
    private final OrderDto orderDto;
    private final Long couponId;

    public BillingDto(@NotNull CustomerDto customerDto, @Valid @NotNull OrderDto orderDto, Long couponId) {
        this.customerDto = customerDto;
        this.orderDto = orderDto;
        this.couponId = couponId;
    }

    public CustomerDto getCustomer() {
        return customerDto;
    }

    public OrderDto getOrder() {
        return orderDto;
    }

    public Long getCoupon() {
        return couponId;
    }

    public Billing toModel(EntityManager entityManager){ // 1 - Billing
        Customer customer = customerDto.toModel(entityManager);
        @NotNull Order order = orderDto.toModel(entityManager);
        Coupon coupon = checkCoupon(entityManager);
        return new Billing(customer,order,coupon);
    }

    public Coupon checkCoupon(EntityManager entityManager){
        if( couponId != null) {
            @EntityValueExists(entityClass = Coupon.class, entityFieldName = "code", expectedAssertion = true, message = "ainda não existe")
            Coupon coupon = entityManager.find(Coupon.class, couponId);
            return coupon;
        }
        return null;
    }
}
