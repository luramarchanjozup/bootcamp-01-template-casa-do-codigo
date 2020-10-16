package dev.arielalvesdutrazup.cdc.unit.utils;

import dev.arielalvesdutrazup.cdc.utils.BigDecimalUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class BigDecimalUtilsTest {

    @Test
    public void maiorQue_comNumeroMaior_deveRetornarVerdadeiro() {
        var de = new BigDecimal("100.00");
        var com = new BigDecimal("80.00");

        assertThat(BigDecimalUtils.maiorQue(de, com)).isTrue();
    }

    @Test
    public void maiorQue_comNumeroMenor_deveRetornarFalso() {
        var de = new BigDecimal("60.00");
        var com = new BigDecimal("100.00");

        assertThat(BigDecimalUtils.maiorQue(de, com)).isFalse();
    }

    @Test
    public void maiorQue_comNumeroIgual_deveRetornarFalso() {
        var de = new BigDecimal("100.00");
        var com = new BigDecimal("100.00");

        assertThat(BigDecimalUtils.maiorQue(de, com)).isFalse();
    }

    @Test
    public void porcentagemDe_comNumerosValidos_deveFuncionar() {
        var porcentagem = 25;
        var total = new BigDecimal("300.00");

        assertThat(BigDecimalUtils.porcentagemDe(porcentagem, total)).isEqualTo(new BigDecimal("75"));

        porcentagem = 10;
        total = new BigDecimal("99.00");

        assertThat(BigDecimalUtils.porcentagemDe(porcentagem, total)).isEqualTo(new BigDecimal("9.9"));
    }

    @Test
    public void discontaPorcentagemDe_comNumerosValidos_deveFuncionar(){
        var porcentagem = 10;
        var total = new BigDecimal("300.00");

        assertThat(BigDecimalUtils.discontaPorcentagemDe(porcentagem, total)).isEqualTo(new BigDecimal("270.00"));

        porcentagem = 80;
        total = new BigDecimal("200.00");

        assertThat(BigDecimalUtils.discontaPorcentagemDe(porcentagem, total)).isEqualTo(new BigDecimal("40.00"));
    }
}
