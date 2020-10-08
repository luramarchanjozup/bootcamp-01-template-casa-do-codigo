package com.casadocodigo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotBlank
	private String name;

	@ManyToOne
	@NotNull
	@Valid
	private Country country;

	@Deprecated
	public State() {

	}

	public State(@NotBlank String name, @NotNull @Valid Country country) {
		super();
		this.name = name;
		this.country = country;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + ", country=" + country + "]";
	}

	public boolean belongToCountry(@Valid Country country) {
		return this.country.equals(country);
	}

}
