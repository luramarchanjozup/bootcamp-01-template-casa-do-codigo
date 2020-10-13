package br.com.thyagoribeiro.casadocodigo.utils;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HandlerAdviceTest {

    /*
    @Test
    @DisplayName("Validacao de campos retornando erro 400")
    void autorCriado() throws Exception {

        NovoAutorRequest novoAutorRequest = new NovoAutorRequest(null, "tolkien@teste..com..br" ,null);

        TestRestTemplate restTemplate = new TestRestTemplate();

        URI uri = new URI("http://localhost:8080/api/autor");
        ResponseEntity<String> response = restTemplate.postForEntity(uri, novoAutorRequest, String.class);
        assertEquals(400, response.getStatusCodeValue());

    }
    */

}