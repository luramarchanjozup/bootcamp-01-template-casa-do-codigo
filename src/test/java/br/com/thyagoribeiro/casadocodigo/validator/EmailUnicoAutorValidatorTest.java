package br.com.thyagoribeiro.casadocodigo.validator;

import br.com.thyagoribeiro.casadocodigo.repository.AutorRepository;
import br.com.thyagoribeiro.casadocodigo.rest.contract.NovoAutorRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class EmailUnicoAutorValidatorTest {

    @Test
    @DisplayName("Verifica se o autor que está sendo inserido possui um e-mail ja cadastrado na base")
    public void emailCadastradoTest() {

        AutorRepository autorRepository = mock(AutorRepository.class);

        NovoAutorRequest novoAutorRequest = new NovoAutorRequest("J. R. R. Tolkien", "tolkien@teste.com.br" ,"Autor de livros de fantasia.");
        Mockito.when(autorRepository.findByEmail(novoAutorRequest.getEmail())).thenReturn(Optional.of(novoAutorRequest.toModel()));

        Errors errors = new BeanPropertyBindingResult(novoAutorRequest, "");

        EmailUnicoAutorValidator emailUnicoAutorValidator = new EmailUnicoAutorValidator(autorRepository);
        emailUnicoAutorValidator.validate(novoAutorRequest, errors);
        assertEquals(errors.getFieldError().getField(), "email");
        assertEquals(errors.getFieldError().getDefaultMessage(), "já foi criado em outro registro");

    }

}