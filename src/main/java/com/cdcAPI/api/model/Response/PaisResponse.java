package com.cdcAPI.api.model.Response;

import com.cdcAPI.model.Pais;

public class PaisResponse {

    private Long paisId;

    public PaisResponse(Pais pais) {
        paisId = pais.getId();
    }

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }
}
