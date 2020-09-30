package br.com.thyagoribeiro.casadocodigo.rest;

import br.com.thyagoribeiro.casadocodigo.repository.AutorRepository;
import br.com.thyagoribeiro.casadocodigo.rest.contract.NovoAutorRequest;
import br.com.thyagoribeiro.casadocodigo.validator.EmailUnicoAutorValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@SpringBootTest
@AutoConfigureMockMvc
class AutorControllerTests {

    @Test
    @DisplayName("Verifica se eh criado um novo(a) autor(a) na base")
    void criaAutorTest() throws Exception {

        EntityManager entityManager = mock(EntityManager.class);
        AutorRepository autorRepository = mock(AutorRepository.class);
        EmailUnicoAutorValidator emailUnicoAutorValidator = new EmailUnicoAutorValidator(autorRepository);
        AutorController autorController = new AutorController(entityManager, emailUnicoAutorValidator);

        NovoAutorRequest novoAutorRequest = new NovoAutorRequest("J. R. R. Tolkien", "tolkien@teste.com.br" ,"Autor de livros de fantasia.");

        ResponseEntity response = autorController.novoAutor(novoAutorRequest);
        assertEquals(200, response.getStatusCodeValue());

    }

}
