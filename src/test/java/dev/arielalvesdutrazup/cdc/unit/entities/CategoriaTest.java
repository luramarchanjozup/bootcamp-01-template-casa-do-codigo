package dev.arielalvesdutrazup.cdc.unit.entities;

import dev.arielalvesdutrazup.cdc.entities.Categoria;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoriaTest {

    @Test
    public void construtorVazio_deveFuncionar() {
        new Categoria();
    }

    @Test
    public void getterESetter_devemFuncionar() {
        var id = 1L;
        var nome = "Drama";
        var timestamp = OffsetDateTime.now();

        var categoria = new Categoria()
                .setId(id)
                .setNome(nome)
                .setCadastradoEm(timestamp);

        assertThat(categoria).isNotNull();
        assertThat(categoria.getId()).isEqualTo(id);
        assertThat(categoria.getNome()).isEqualTo(nome);
        assertThat(categoria.getCadastradoEm()).isEqualTo(timestamp);
    }

    @Test
    public void cadastradoEm_deveSerGeradoAoCriarOObjeto() {
        assertThat(new Categoria().getCadastradoEm()).isNotNull();
    }

    @Test
    public void equals_deveSerPorId() {
        var id = 1L;

        var categoria1 = new Categoria().setId(id);
        var categoria2 = new Categoria().setId(id);

        assertThat(categoria1).isEqualTo(categoria2);
    }
}
