package br.com.thyagoribeiro.casadocodigo.validator;

import br.com.thyagoribeiro.casadocodigo.repository.AutorRepository;
import br.com.thyagoribeiro.casadocodigo.repository.CategoriaRepository;
import br.com.thyagoribeiro.casadocodigo.rest.contract.NovaCategoriaRequest;
import br.com.thyagoribeiro.casadocodigo.rest.contract.NovoAutorRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class NomeUnicoCategoriaValidatorTest {

    @Test
    @DisplayName("Verifica se a categoria que está sendo inserida possui um nome ja cadastrado na base")
    public void emailCadastradoTest() {

        CategoriaRepository categoriaRepository = mock(CategoriaRepository.class);

        NovaCategoriaRequest novaCategoriaRequest = new NovaCategoriaRequest("Fantasia");
        Mockito.when(categoriaRepository.findByNome(novaCategoriaRequest.getNome())).thenReturn(Optional.of(novaCategoriaRequest.toModel()));

        Errors errors = new BeanPropertyBindingResult(novaCategoriaRequest, "");

        NomeUnicoCategoriaValidator nomeUnicoCategoriaValidator = new NomeUnicoCategoriaValidator(categoriaRepository);
        nomeUnicoCategoriaValidator.validate(novaCategoriaRequest, errors);
        assertEquals(errors.getFieldError().getField(), "nome");
        assertEquals(errors.getFieldError().getDefaultMessage(), "ja existe uma categoria com esse nome");

    }

}