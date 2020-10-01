package com.casadocodigo.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.casadocodigo.entity.Author;
import com.casadocodigo.validators.UniqueValue;

public class AuthorRequest {

	@NotBlank
	private String name;

	@NotBlank
	@Email
	@UniqueValue(domainClass = Author.class,fieldName = "email", message = "email já cadastrado!")
	private String email;

	@NotBlank
	@Size(max = 400)
	private String description;

	public AuthorRequest(@NotBlank String name, 
			@NotBlank @Email String email,
			@NotBlank @Size(max = 400) String description) {
		super();
		this.name = name;
		this.email = email;
		this.description = description;
	}
	
	public Author toModel() {
		return new Author(this.name, this.email, this.description);
	}

	public String getEmail() {
		return email;
	}

}
