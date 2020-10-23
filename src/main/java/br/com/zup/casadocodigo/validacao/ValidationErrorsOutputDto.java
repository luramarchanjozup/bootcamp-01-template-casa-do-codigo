package br.com.zup.casadocodigo.validacao;

import java.util.ArrayList;
import java.util.List;

//1
public class ValidationErrorsOutputDto {

	private List<String> globalErrorMessages = new ArrayList<>();
	// 1
	private List<FieldErrorOutputDto> fieldErrors = new ArrayList<>();

	public void addError(String message) {
		globalErrorMessages.add(message);
	}

	public void addFieldError(String field, String message) {
		FieldErrorOutputDto fieldError = new FieldErrorOutputDto(field, message);
		fieldErrors.add(fieldError);
	}

	public List<String> getGlobalErrorMessages() {
		return globalErrorMessages;
	}

	public List<FieldErrorOutputDto> getErrors() {
		return fieldErrors;
	}

	public int getNumberOfErrors() {
		return this.globalErrorMessages.size() + this.fieldErrors.size();
	}
}
