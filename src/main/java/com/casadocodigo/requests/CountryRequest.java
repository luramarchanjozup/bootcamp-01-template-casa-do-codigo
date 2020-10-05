package com.casadocodigo.requests;

import javax.validation.constraints.NotBlank;

import com.casadocodigo.annotations.UniqueValue;
import com.casadocodigo.entity.Country;

public class CountryRequest {

	@NotBlank
	@UniqueValue(domainClass = Country.class,fieldName = "name", message = "País Já cadastrado!")
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
