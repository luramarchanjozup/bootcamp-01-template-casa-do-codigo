package br.com.zup.casadocodigo.validator;

import br.com.zup.casadocodigo.domain.Coupon;
import br.com.zup.casadocodigo.dto.BuyerDTO;
import br.com.zup.casadocodigo.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CouponValidator implements Validator {

    @Autowired
    private CouponRepository couponRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return BuyerDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        BuyerDTO buyerDTO = (BuyerDTO) target;
        Optional<String> oneCode = buyerDTO.getCodeCoupon();

        if(oneCode.isPresent()) {
            Coupon coupon = couponRepository.findByCode(oneCode.get());
            if(!coupon.valid()) {
                errors.rejectValue("codeCoupon", null, "coupon is no longer valid");
            }
        }

    }
}
