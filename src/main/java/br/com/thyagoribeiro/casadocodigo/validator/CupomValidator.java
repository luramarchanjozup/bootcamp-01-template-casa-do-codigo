package br.com.thyagoribeiro.casadocodigo.validator;

import br.com.thyagoribeiro.casadocodigo.domain.Cupom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.util.List;

public class CupomValidator implements ConstraintValidator<CupomValido, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(CupomValido constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        context.disableDefaultConstraintViolation();

        Query query = entityManager.createQuery("SELECT c FROM Cupom c WHERE id = :id");
        query.setParameter("id", value);

        List<Cupom> cupomList = query.getResultList();
        if(cupomList.isEmpty()) {
            context.buildConstraintViolationWithTemplate("não existe").addConstraintViolation();
            return false;
        }

        if(cupomList.get(0).getValidade().isBefore(LocalDate.now())) {
            context.buildConstraintViolationWithTemplate("não está dentro da validade").addConstraintViolation();
            return false;
        }

        return true;
    }
}
