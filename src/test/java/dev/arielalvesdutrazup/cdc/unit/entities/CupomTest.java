package dev.arielalvesdutrazup.cdc.unit.entities;

import dev.arielalvesdutrazup.cdc.entities.Cupom;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class CupomTest {

    @Test
    public void construtorVazio_deveFuncionar() {
        new Cupom();
    }

    @Test
    public void gettersESetter_devemFuncionar() {
        var id = 1L;
        var codigo = "PROMOZUP20";
        var validade  = OffsetDateTime.now().plusDays(10);
        var timestamp = OffsetDateTime.now();
        var percentualDeDesconto = 10;

        var cupom = new Cupom()
                .setId(id)
                .setCodigo(codigo)
                .setPercentualDeDesconto(percentualDeDesconto)
                .setValidade(validade)
                .setCadastradoEm(timestamp)
                .setAtualizadoEm(timestamp);

        assertThat(cupom).isNotNull();
        assertThat(cupom.getId()).isEqualTo(1L);
        assertThat(cupom.getCodigo()).isEqualTo(codigo);
        assertThat(cupom.getPercentualDeDesconto()).isEqualTo(10);
        assertThat(cupom.getValidade()).isEqualTo(validade);
        assertThat(cupom.getCadastradoEm()).isEqualTo(timestamp);
        assertThat(cupom.getAtualizadoEm()).isEqualTo(timestamp);
    }

    @Test
    public void cadastradoEm_deveSerGeradoAoCriarOObjeto() {
        assertThat(new Cupom().getCadastradoEm()).isNotNull();
    }
}
