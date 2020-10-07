
package dev.arielalvesdutrazup.cdc.unit.entities;

import dev.arielalvesdutrazup.cdc.entities.Estado;
import dev.arielalvesdutrazup.cdc.entities.Pais;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class EstadoTest {

    @Test
    public void construtorVazio_deveFuncionar() {
        new Estado();
    }

    @Test
    public void gettersESetter_devemFuncionar() {
        var id = 1L;
        var nome = "Rio Grande do Sul";
        var codigo = "RS";
        var timestamp = OffsetDateTime.now();
        var pais = new Pais();

        var estado = new Estado()
                .setId(id)
                .setNome(nome)
                .setCodigo(codigo)
                .setCadastradoEm(timestamp)
                .setPais(pais);

        assertThat(estado).isNotNull();
        assertThat(estado.getId()).isEqualTo(1L);
        assertThat(estado.getNome()).isEqualTo(nome);
        assertThat(estado.getCodigo()).isEqualTo(codigo);
        assertThat(estado.getCadastradoEm()).isEqualTo(timestamp);
        assertThat(estado.getPais()).isEqualTo(pais);
    }

    @Test
    public void cadastradoEm_deveSerGeradoAoCriarOObjeto() {
        assertThat(new Estado().getCadastradoEm()).isNotNull();
    }
}
