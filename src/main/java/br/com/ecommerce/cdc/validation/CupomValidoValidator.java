package br.com.ecommerce.cdc.validation;

import br.com.ecommerce.cdc.anotacao.CupomValido;
import br.com.ecommerce.cdc.domain.model.CupomDesconto;
import br.com.ecommerce.cdc.repository.CupomDescontoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

/**
 * Carga Intrínseca máxima permitida - 7
 * Carga Intrínseca da classe - 3
 * */

// +1(CupomValido)
public class CupomValidoValidator implements ConstraintValidator<CupomValido, String> {

    @Autowired
    // +1
    private CupomDescontoRepository cupomDescontoRepository;

    @Override
    public void initialize(CupomValido constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        // +1
        Optional<CupomDesconto> cupomDescontoByCodigo = cupomDescontoRepository.findByCodigo(value);

        if (cupomDescontoByCodigo.isPresent() && cupomDescontoByCodigo.get().cupomValido()){
            return true;
        }

        return false;
    }


}
