package dev.arielalvesdutrazup.cdc.unit.entities;

import dev.arielalvesdutrazup.cdc.entities.Autor;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class AutorTest {

    @Test
    public void construtorVazio_deveFuncionar() {
        new Autor();
    }

    @Test
    public void getterESetter_devemFuncionar() {
        var id = 1L;
        var nome = "Geralt de Rivia";
        var email = "exemplo@exemplo.com.br";
        var descricao = "Geralt é uma autor renomado, com 100 anos de experiência";
        var timestamp = OffsetDateTime.now();

        var autor = new Autor()
                .setId(id)
                .setNome(nome)
                .setEmail(email)
                .setDescricao(descricao)
                .setCadastradoEm(timestamp);

        assertThat(autor).isNotNull();
        assertThat(autor.getId()).isEqualTo(id);
        assertThat(autor.getNome()).isEqualTo(nome);
        assertThat(autor.getEmail()).isEqualTo(email);
        assertThat(autor.getDescricao()).isEqualTo(descricao);
        assertThat(autor.getCadastradoEm()).isEqualTo(timestamp);
    }

    @Test
    public void cadastradoEm_deveSerGeradoAoCriarOObjeto() {
        assertThat(new Autor().getCadastradoEm()).isNotNull();
    }
}
