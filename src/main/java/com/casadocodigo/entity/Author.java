package com.casadocodigo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long authorId;

	@NotBlank
	private String name;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	@Size(max = 400)
	private String description;

	@NotNull
	private LocalDateTime createdAt = LocalDateTime.now();

	@Deprecated
	public Author() {

	}
	
	public Author(@NotEmpty String name, @NotEmpty @Email String email, @NotEmpty @Size(max = 400) String description) {
		this.name = name;
		this.email = email;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", name=" + name + ", email=" + email + ", description=" + description
				+ ", createdAt=" + createdAt + "]";
	};
	
}
