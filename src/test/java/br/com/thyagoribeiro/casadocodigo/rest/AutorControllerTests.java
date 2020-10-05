package br.com.thyagoribeiro.casadocodigo.rest;

import br.com.thyagoribeiro.casadocodigo.rest.contract.NovoAutorRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.doNothing;


@SpringBootTest
@AutoConfigureMockMvc
class AutorControllerTests {

    @Mock
    private AutorController autorController;

    @Mock
    private Validator validator;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Verifica se eh criado um novo(a) autor(a) na base")
    void criaAutorTest() throws Exception {

        NovoAutorRequest novoAutorRequest = new NovoAutorRequest("J. R. R. Tolkien", "tolkien@teste.com.br" ,"Autor de livros de fantasia.");
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc = MockMvcBuilders.standaloneSetup(autorController).setValidator(validator).build();

        mockMvc.perform(post("/api/autor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(novoAutorRequest)))
                .andExpect(status().isOk());

    }

}
