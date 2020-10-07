package dev.arielalvesdutrazup.cdc.factories.entities;

import dev.arielalvesdutrazup.cdc.entities.Estado;
import dev.arielalvesdutrazup.cdc.entities.Pais;

/**
 * Classe auxiliar para testes.
 */
public class EstadoFactory {

    public static Estado paraPersistir(Pais pais) {
        return new Estado()
                .setNome("Rio Grande do Sul")
                .setCodigo("RS")
                .setPais(pais);
    }
}
