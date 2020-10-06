package com.casadocodigo.casaDoCodigo.controllers.dto;

import javax.persistence.EntityManager;

import com.casadocodigo.casaDoCodigo.controllers.form.PurchaseForm;
import com.casadocodigo.casaDoCodigo.model.Country;
import com.casadocodigo.casaDoCodigo.model.State;

public class ClientCountry {
    private State state;
    private Country country;

    public ClientCountry (EntityManager manager, PurchaseForm form) {
        this.state = manager.createQuery("SELECT s FROM State s WHERE s.name = :name", State.class)
                    .setParameter("name", form.getState()).getSingleResult();
        this.country = manager.createQuery("SELECT c FROM Country c WHERE c.name = :name", Country.class)
                    .setParameter("name", form.getCountry()).getSingleResult();
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
