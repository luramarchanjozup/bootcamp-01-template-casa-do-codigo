package com.casadocodigo.requests;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import com.casadocodigo.annotations.ExistsValue;
import com.casadocodigo.annotations.UniqueValue;
import com.casadocodigo.entity.Country;
import com.casadocodigo.entity.State;

public class StateRequest {

	@NotBlank
	@UniqueValue(domainClass = State.class,fieldName = "name", message = "Estado Já cadastrado!")
	private String name;
	
	@NotNull
	@ExistsValue(domainClass = Country.class, fieldName = "id", message = "O País deve existir")
	private Long idCountry;

	public StateRequest(@NotBlank String name, @NotNull Long idCountry) {
		super();
		this.name = name;
		this.idCountry = idCountry;
	}
	
	public State toModel(EntityManager manager) {
		@NotNull
		Country country = manager.find(Country.class, idCountry);
		
		Assert.state(country!=null, "O País precisa estar cadastrado "+idCountry);
		
		return new State(name, country);
	}

}
