package com.bootcamp.cdd.request;

import com.bootcamp.cdd.models.Country;
import com.bootcamp.cdd.models.State;
import com.bootcamp.cdd.shared.UniqueValue;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

public class StateRequest {
    @NotBlank(message = "O nome do estado precisa ser preenchido")
    @UniqueValue(domainClass = State.class, fieldName = "name", message = "esse estado ja foi criado")
    private String name;
    private long countryId;

    public StateRequest(@NotBlank(message = "O nome do estado precisa ser preenchido") String name, long countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    public StateRequest() {
    }

    public String getName() {
        return name;
    }

    public long getCountryId() {
        return countryId;
    }

    public State toModel (EntityManager manager) {
        Country country = manager.find(Country.class, this.countryId);
        Assert.state(country != null, "não foi encontrado o pais informado");
        return new State(this.name, country);
    }
}
