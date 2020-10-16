package br.com.zup.casadocodigo.repository;

import br.com.zup.casadocodigo.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CouponRepository extends org.springframework.data.repository.Repository<Coupon, Long> {

    public Coupon findByCode(String code);

}