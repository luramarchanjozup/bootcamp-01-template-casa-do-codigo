package br.com.zup.treinocasadocodigo.entities;

import java.util.Collection;

/**
 * Contagem de carga intrínseca da classe: 0
 */

public class ErroPadronizado {
    private Collection<String> mensagens;

    public ErroPadronizado(Collection<String> mensagens) {
        this.mensagens = mensagens;
    }

    public Collection<String> getMensagens() {
        return mensagens;
    }

    public void setMensagens(Collection<String> mensagens) {
        this.mensagens = mensagens;
    }
}
