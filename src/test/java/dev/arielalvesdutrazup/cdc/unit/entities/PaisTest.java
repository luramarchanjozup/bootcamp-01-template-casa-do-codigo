package dev.arielalvesdutrazup.cdc.unit.entities;

import dev.arielalvesdutrazup.cdc.entities.Pais;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class PaisTest {

    @Test
    public void construtorVazio_deveFuncionar() {
        new Pais();
    }

    @Test
    public void gettersESetter_devemFuncionar() {
        var id = 1L;
        var nome = "Brasil";
        var codigo = "BR";
        var timestamp = OffsetDateTime.now();

        var pais = new Pais()
                .setId(id)
                .setNome(nome)
                .setCodigo(codigo)
                .setCadastradoEm(timestamp)
                .setEstados(new HashSet<>());

        assertThat(pais).isNotNull();
        assertThat(pais.getId()).isEqualTo(1L);
        assertThat(pais.getNome()).isEqualTo(nome);
        assertThat(pais.getCodigo()).isEqualTo(codigo);
        assertThat(pais.getCadastradoEm()).isEqualTo(timestamp);
        assertThat(pais.getEstados()).isEmpty();
    }

    @Test
    public void cadastradoEm_deveSerGeradoAoCriarOObjeto() {
        assertThat(new Pais().getCadastradoEm()).isNotNull();
    }

    @Test
    public void equals_deveSerPorId() {
        var id = 1L;

        var pais1 = new Pais().setId(id);
        var pais2 = new Pais().setId(id);

        assertThat(pais1).isEqualTo(pais2);
    }
}
