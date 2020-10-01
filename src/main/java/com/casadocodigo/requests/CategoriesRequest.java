package com.casadocodigo.requests;

import javax.validation.constraints.NotBlank;

import com.casadocodigo.entity.Categories;
import com.casadocodigo.validators.UniqueValue;

public class CategoriesRequest {

	@NotBlank
	@UniqueValue(domainClass = Categories.class,fieldName = "name", message = "nome já cadastrado!")
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
