package br.com.itau.casadocodigo.cadastropaisestado.model;

public class PaisResponse {

    private final Long id;
    private final String pais;

    public Long getId() {
        return id;
    }

    public String getPais() {
        return pais;
    }

    public PaisResponse(Pais pais) {
        this.id = pais.getId();
        this.pais = pais.getPais();
    }
}
