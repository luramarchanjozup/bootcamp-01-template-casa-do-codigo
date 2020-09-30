package br.com.casadocodigo.forms;

import br.com.casadocodigo.models.Category;
import br.com.casadocodigo.models.State;

public class StateForm {

    private String name;

    @Deprecated
    public StateForm(){ }

    public StateForm(String name){
        this.name = name;
    }

    public State toEntity(){
        return new State(name);
    }

    public void setName(String name) {
        this.name = name;
    }

}
