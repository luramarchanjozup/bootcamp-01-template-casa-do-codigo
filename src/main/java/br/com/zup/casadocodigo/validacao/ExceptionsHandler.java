package br.com.zup.casadocodigo.validacao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

//8
@RestControllerAdvice
public class ExceptionsHandler {

	@Autowired
	private MessageSource messageSource;

	private static final Logger log = LoggerFactory.getLogger(ExceptionsHandler.class);

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	// 1
	public ValidationErrorsOutputDto handleValidationError(MethodArgumentNotValidException exception) {

		List<ObjectError> globalErrors = exception.getBindingResult().getGlobalErrors();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

		return buildValidationErrors(globalErrors, fieldErrors);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	public ValidationErrorsOutputDto handleValidationError(BindException exception) {

		List<ObjectError> globalErrors = exception.getBindingResult().getGlobalErrors();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

		return buildValidationErrors(globalErrors, fieldErrors);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ValidationErrorsOutputDto handleValidationError(HttpMessageNotReadableException exception) {
		log.error("Problema na de desserializar o objeto", exception);

		InvalidFormatException invalidFormat = (InvalidFormatException) exception.getCause();

		// 1
		List<ObjectError> globalErrors = List
				.of(new ObjectError("", invalidFormat.getValue() + " não é um valor válido"));
		List<FieldError> fieldErrors = List.of();

		return buildValidationErrors(globalErrors, fieldErrors);
	}

	private ValidationErrorsOutputDto buildValidationErrors(List<ObjectError> globalErrors,
			List<FieldError> fieldErrors) {
		ValidationErrorsOutputDto validationErrors = new ValidationErrorsOutputDto();
//1
//1
		globalErrors.forEach(error -> validationErrors.addError(getErrorMessage(error)));

		// 1
		// 1
		// 1
		fieldErrors.forEach(error -> {
			String errorMessage = getErrorMessage(error);
			validationErrors.addFieldError(error.getField(), errorMessage);
		});
		return validationErrors;
	}

	private String getErrorMessage(ObjectError error) {
		// 1
		return messageSource.getMessage(error, LocaleContextHolder.getLocale());
	}

}
