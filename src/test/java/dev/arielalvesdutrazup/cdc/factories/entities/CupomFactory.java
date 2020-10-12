package dev.arielalvesdutrazup.cdc.factories.entities;

import dev.arielalvesdutrazup.cdc.entities.Cupom;

import java.time.OffsetDateTime;

/**
 * Classe auxiliar para testes.
 */
public class CupomFactory {

    public static Cupom paraPersistir() {
        var validate = OffsetDateTime.now().plusDays(20);

        return new Cupom()
                .setCodigo("ZUP10")
                .setPercentualDeDesconto(10)
                .setValidade(validate);
    }
}
