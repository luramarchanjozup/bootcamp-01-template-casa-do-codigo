package br.com.casadocodigo.validator;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorsOutput {
    private List<String> globalErrorMessages = new ArrayList<>();
    private List<FieldErrorOutput> fieldErrors = new ArrayList<>();

    public void addError(String message) {
        globalErrorMessages.add(message);
    }

    public void addFieldError(String field, String message) {
        FieldErrorOutput fieldError = new FieldErrorOutput(field, message);
        fieldErrors.add(fieldError);
    }

    public List<String> getGlobalErrorMessages() {
        return globalErrorMessages;
    }

    public List<FieldErrorOutput> getErrors() {
        return fieldErrors;
    }

    public int getNumberOfErrors() {
        return this.globalErrorMessages.size() + this.fieldErrors.size();
    }
}
