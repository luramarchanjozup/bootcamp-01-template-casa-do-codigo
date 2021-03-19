package br.com.casadocodigo.repositories;

import br.com.casadocodigo.models.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, Long> {

    Coupon findByCode(String code);

}
