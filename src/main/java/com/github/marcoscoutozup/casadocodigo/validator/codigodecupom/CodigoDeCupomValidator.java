package com.github.marcoscoutozup.casadocodigo.validator.codigodecupom;

import com.github.marcoscoutozup.casadocodigo.fluxocompra.cupom.Cupom;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.cupom.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class CodigoDeCupomValidator implements ConstraintValidator<CodigoDeCupom, String> {

    @Autowired
    private CupomRepository cupomRepository;

    @Override
    public void initialize(CodigoDeCupom constraintAnnotation) {

    }

    @Override
    public boolean isValid(String codigoDeCupom, ConstraintValidatorContext constraintValidatorContext) {
        return codigoDeCupom == null || verificarValidadeDoCupom(codigoDeCupom);
    }

    private boolean verificarValidadeDoCupom(String codigoDeCupom){
        Optional<Cupom> cupom = cupomRepository.findByCodigo(codigoDeCupom);
        return cupom.isPresent() && cupom.get().estaValido();
    }
}
