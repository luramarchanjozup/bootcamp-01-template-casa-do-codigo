package br.com.thyagoribeiro.casadocodigo.rest;

import br.com.thyagoribeiro.casadocodigo.rest.contract.NovaCategoriaRequest;
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
public class CategoriaControllerTest {

    @Mock
    private NovoCategoriaController categoriaController;

    @Mock
    private Validator validator;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Verifica se eh criada uma nova categoria na base")
    public void novaCategoria() throws Exception {

        NovaCategoriaRequest novaCategoriaRequest = new NovaCategoriaRequest("Teste");
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc = MockMvcBuilders.standaloneSetup(categoriaController).setValidator(validator).build();

        mockMvc.perform(post("/api/categoria")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(novaCategoriaRequest)))
                .andExpect(status().isOk());

    }

}