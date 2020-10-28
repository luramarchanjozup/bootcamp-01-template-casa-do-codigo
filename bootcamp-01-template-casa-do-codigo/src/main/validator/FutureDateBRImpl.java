package com.apicasadocodigo.casadocodigo.service.validator;

import com.apicasadocodigo.casadocodigo.util.ConvertDateToBrFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class FutureDateBRImpl implements ConstraintValidator<FutureDateBR, String> {

    @Override
    public boolean isValid(String releaseDate, ConstraintValidatorContext context) {

        LocalDate localDateFromDateBookPublicantion = ConvertDateToBrFormat.toLocalDate(releaseDate);

        return LocalDate.now().isBefore(localDateFromDateBookPublicantion);
    }
}
