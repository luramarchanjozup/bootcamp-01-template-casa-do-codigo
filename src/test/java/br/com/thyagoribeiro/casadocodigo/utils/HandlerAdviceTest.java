package br.com.thyagoribeiro.casadocodigo.utils;

import br.com.thyagoribeiro.casadocodigo.rest.contract.NovaCategoriaRequest;
import br.com.thyagoribeiro.casadocodigo.rest.contract.NovoAutorRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HandlerAdviceTest {

    @Test
    @DisplayName("Validacao de campos retornando erro 400")
    void autorCriado() throws Exception {

        NovoAutorRequest novoAutorRequest = new NovoAutorRequest(null, "tolkien@teste..com..br" ,null);

        TestRestTemplate restTemplate = new TestRestTemplate();

        URI uri = new URI("http://localhost:8080/api/autor");
        ResponseEntity<String> response = restTemplate.postForEntity(uri, novoAutorRequest, String.class);
        assertEquals(400, response.getStatusCodeValue());

    }

    @Test
    @DisplayName("Validacao de campos retornando erro 400")
    void categoriaCriada() throws Exception {

        NovaCategoriaRequest novaCategoriaRequest = new NovaCategoriaRequest(null);

        TestRestTemplate restTemplate = new TestRestTemplate();

        URI uri = new URI("http://localhost:8080/api/categoria");
        ResponseEntity<String> response = restTemplate.postForEntity(uri, novaCategoriaRequest, String.class);
        assertEquals(400, response.getStatusCodeValue());

    }

}