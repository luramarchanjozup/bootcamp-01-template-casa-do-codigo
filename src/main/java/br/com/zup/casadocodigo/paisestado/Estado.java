package br.com.zup.casadocodigo.paisestado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEstado;

	@NotBlank
	private String nome;

	@ManyToOne
	@NotNull
	@Valid
	private Pais pais;

	@Deprecated
	public Estado() {

	}

	public Estado(@NotBlank String nome, @NotNull @Valid Pais pais) {
		this.nome = nome;
		this.pais = pais;

	}

}
