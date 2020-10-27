package br.com.casadocodigo.validator;

public class FieldErrorOutput {

    private String field;
    private String message;

    FieldErrorOutput() { }

    public FieldErrorOutput(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
