package br.com.ecommerce.cdc.validation;

import br.com.ecommerce.cdc.anotacao.CupomValido;
import br.com.ecommerce.cdc.domain.model.CupomDesconto;
import br.com.ecommerce.cdc.repository.CupomDescontoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

/**
 * Carga Intrínseca máxima permitida - 9
 * Carga Intrínseca da classe - 0
 * */

public class CupomValidoValidator implements ConstraintValidator<CupomValido, String> {

    @Autowired
    private CupomDescontoRepository cupomDescontoRepository;

    @Override
    public void initialize(CupomValido constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        Optional<CupomDesconto> cupomDescontoByCodigp = cupomDescontoRepository.findByCodigo(value);

        if (cupomDescontoByCodigp.isPresent() && cupomDescontoByCodigp.get().cupomValido()){
            return true;
        }

        return false;
    }


}
