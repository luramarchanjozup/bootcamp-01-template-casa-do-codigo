package br.com.casadocodigo.dtos;

import br.com.casadocodigo.models.Country;
import br.com.casadocodigo.models.State;

public class StateDto {

    private String name;

    public StateDto(State state){
        this.name = state.getName();
    }

    public String getName() {
        return name;
    }

}
