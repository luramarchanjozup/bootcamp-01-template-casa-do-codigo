package com.casadocodigo.requests;

import javax.validation.constraints.NotBlank;

public class CategoriesRequest {

	@NotBlank
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
