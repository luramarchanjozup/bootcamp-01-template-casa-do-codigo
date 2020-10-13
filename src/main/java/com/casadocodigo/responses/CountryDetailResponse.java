package com.casadocodigo.responses;

import com.casadocodigo.entity.Country;
import com.casadocodigo.entity.Purchase;

public class CountryDetailResponse {

    private Long id;
    private String name;

    public CountryDetailResponse(Country nameCountry) {
        id = nameCountry.getId();
        name = nameCountry.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
