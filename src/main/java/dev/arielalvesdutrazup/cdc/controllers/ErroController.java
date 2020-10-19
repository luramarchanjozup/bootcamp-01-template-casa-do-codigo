package dev.arielalvesdutrazup.cdc.controllers;

import dev.arielalvesdutrazup.cdc.controllers.dtos.ErroResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

// 1 ErroResponseDTO.java

/**
 * Controller responsável por mapear todos os erros sem
 * uma @ControllerAdvice para especificar o tratamento
 * do erro.
 */
@RestController
public class ErroController extends AbstractErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    public ErroController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
        this.errorAttributes = errorAttributes;
    }

    /**
     * @implNote Mesma implementação da BasicErrorController.
     * @deprecated
     */
    @Override
    public String getErrorPath() {
        return null;
    }

    @RequestMapping("/error")
    public ErroResponseDTO errorHandler(HttpServletRequest request, HttpServletResponse response) {
        return new ErroResponseDTO(response.getStatus(), getErrorAttributes(request));
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
        WebRequest webRequest = new ServletWebRequest(request);
        return errorAttributes.getErrorAttributes(webRequest, getErrorAttributeOptions());
    }

    private ErrorAttributeOptions getErrorAttributeOptions() {
        ErrorAttributeOptions options = ErrorAttributeOptions.defaults();
        return options
                .including(ErrorAttributeOptions.Include.EXCEPTION)
                .including(ErrorAttributeOptions.Include.STACK_TRACE)
                .including(ErrorAttributeOptions.Include.MESSAGE)
                .including(ErrorAttributeOptions.Include.BINDING_ERRORS);
    }
}
