package dev.arielalvesdutrazup.cdc.it.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.fail;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureTestDatabase
@ActiveProfiles("test")
public class LivroControllerIT {

    @Test
    public void cadastrar_deveRetornar200() {
        fail("Não implementado!");
    }

    @Test
    public void cadastrar_comDadosInvalidos_deveRetornar400() {
        fail("Não implementado!");
    }

    @Test
    public void listarTodos_deveRetornar200() {
        fail("Não implementado!");
    }

    @Test
    public void detalhe_deveRetornar200() {
        fail("Não implementado!");
    }

    @Test
    public void detalhe_semLivroCadastrado_deveRetornar404() {
        fail("Não implementado!");
    }
}
