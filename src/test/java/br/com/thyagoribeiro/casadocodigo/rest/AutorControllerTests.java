package br.com.thyagoribeiro.casadocodigo.rest;

import br.com.thyagoribeiro.casadocodigo.rest.contract.NovoAutorRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class AutorControllerTests {

    @Mock
    private NovoAutorController autorController;

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
