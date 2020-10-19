package dev.arielalvesdutrazup.cdc.factories.entities;

import dev.arielalvesdutrazup.cdc.entities.Categoria;

/**
 * Classe auxiliar para testes.
 */
public class CategoriaFactory {

    public static Categoria paraPersistir() {
        return new Categoria()
                .setNome("Fantasia");
    }
}
