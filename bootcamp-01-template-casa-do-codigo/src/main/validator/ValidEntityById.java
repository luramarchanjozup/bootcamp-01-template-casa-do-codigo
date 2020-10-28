package com.apicasadocodigo.casadocodigo.service.validator;

import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidEntityById {

    String message() default "This date must be a future date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<?> typeEntity();

}
