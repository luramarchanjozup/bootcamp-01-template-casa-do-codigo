package com.casadocodigo.responses;

import com.casadocodigo.entity.Country;
import com.casadocodigo.entity.Purchase;

public class CountryDetailResponse {
    private String name;

    public CountryDetailResponse(Country nameCountry) {
        name = nameCountry.getName();
    }

    public String getName() {
        return name;
    }

}
