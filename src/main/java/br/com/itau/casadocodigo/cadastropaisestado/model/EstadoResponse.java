package br.com.itau.casadocodigo.cadastropaisestado.model;

public class EstadoResponse {

    private final Long id;
    private final String estado;
    private final Pais pais;

    public Long getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public Pais getPais() {
        return pais;
    }

    public EstadoResponse(Estado estado) {
        this.id = estado.getId();
        this.estado = estado.getEstado();
        this.pais = estado.getPais();
    }
}
