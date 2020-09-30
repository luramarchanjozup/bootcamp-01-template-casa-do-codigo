package br.com.thyagoribeiro.casadocodigo.rest;

import br.com.thyagoribeiro.casadocodigo.repository.CategoriaRepository;
import br.com.thyagoribeiro.casadocodigo.rest.contract.NovaCategoriaRequest;
import br.com.thyagoribeiro.casadocodigo.validator.NomeUnicoCategoriaValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@SpringBootTest
@AutoConfigureMockMvc
class CategoriaControllerTest {

    @Test
    @DisplayName("Verifica se eh criado uma nova categoria na base")
    void novaCategoria() {

        EntityManager entityManager = mock(EntityManager.class);
        CategoriaRepository categoriaRepository = mock(CategoriaRepository.class);
        NomeUnicoCategoriaValidator nomeUnicoCategoriaValidator = new NomeUnicoCategoriaValidator(categoriaRepository);
        CategoriaController categoriaController = new CategoriaController(entityManager, nomeUnicoCategoriaValidator);

        NovaCategoriaRequest novaCategoriaRequest = new NovaCategoriaRequest("Fantasia");

        ResponseEntity response = categoriaController.novaCategoria(novaCategoriaRequest);
        assertEquals(200, response.getStatusCodeValue());

    }
}