package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.validation;

import java.util.Collection;

public class ErroParonizado {
    Collection<String> mensagens;

    public ErroParonizado(Collection<String> mensagens) {
        this.mensagens = mensagens;
    }

    public Collection<String> getMensagens() {
        return mensagens;
    }

    public void setMensagens(Collection<String> mensagens) {
        this.mensagens = mensagens;
    }
}
