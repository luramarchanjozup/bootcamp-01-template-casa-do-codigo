package br.com.thyagoribeiro.casadocodigo.rest;

import br.com.thyagoribeiro.casadocodigo.rest.contract.NovoLivroRequest;
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

import java.math.BigDecimal;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LivroControllerTests {

    @Mock
    private NovoLivroController livroController;

    @Mock
    private Validator validator;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Verifica se eh criado um novo livro na base")
    void criaLivroTest() throws Exception {

        NovoLivroRequest novoLivroRequest = new NovoLivroRequest("Titulo teste",
                "Resumo teste",
                "Sumario teste",
                new BigDecimal(20.0),
                100,
                "ISBN teste",
                new Date(),
                0L,
                0L);
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc = MockMvcBuilders.standaloneSetup(livroController).setValidator(validator).build();

        mockMvc.perform(post("/api/livro")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(novoLivroRequest)))
                .andExpect(status().isOk());

    }

}
