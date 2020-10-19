package dev.arielalvesdutrazup.cdc.factories.entities;

import dev.arielalvesdutrazup.cdc.entities.Pais;

/**
 * Classe auxiliar para testes.
 */
public class PaisFactory {

    public static Pais paraPersistir() {
        return new Pais()
                .setNome("Brasil")
                .setCodigo("BR");
    }
}
