package br.com.carlos.casadocodigo.api.handler;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class ErroPadronizado {
    private Collection<String> mensagens;

    public ErroPadronizado(Collection<String> mensagens) {
        this.mensagens = mensagens;
    }
}
