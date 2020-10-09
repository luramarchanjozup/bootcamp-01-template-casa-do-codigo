package com.casadocodigo.responses;

import com.casadocodigo.entity.Country;
import com.casadocodigo.entity.State;

public class StateDetailResponse {
    private String name;

    public StateDetailResponse(State nameState) {
        name = nameState.getName();
    }

    public String getName() {
        return name;
    }

}
