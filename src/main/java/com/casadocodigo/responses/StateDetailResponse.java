package com.casadocodigo.responses;


import com.casadocodigo.entity.State;

public class StateDetailResponse {
    private Long id;
    private String name;

    public StateDetailResponse(State nameState) {
        id = nameState.getId();
        name = nameState.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
