package com.casadocodigo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categories {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotBlank
	private String name;

	@Deprecated
	public Categories() {

	}

	public Categories(@NotBlank String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Categories [id=" + id + ", name=" + name + "]";
	}

}
