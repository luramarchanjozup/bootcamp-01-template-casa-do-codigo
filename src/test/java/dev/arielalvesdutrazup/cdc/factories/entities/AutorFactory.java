package dev.arielalvesdutrazup.cdc.factories.entities;

import dev.arielalvesdutrazup.cdc.entities.Autor;

/**
 * Classe auxiliar para testes.
 */
public class AutorFactory {

    public static Autor paraPersistir() {
        return new Autor()
                .setNome("George R. R. Martin")
                .setEmail("contact@grrmartin.us")
                .setDescricao("George Raymond Richard Martin, also known as GRRM, is an American novelist and short story writer, screenwriter, and television producer.");

    }
}
