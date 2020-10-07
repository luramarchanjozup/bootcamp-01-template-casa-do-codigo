package com.itau.cdc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;

import com.itau.cdc.configuration.exception.ApiErroException;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@NotBlank
	@Column(name="nome", nullable = false)
	private String nome;
	
	@NotNull
	@ManyToOne
	private Pais pais;

	public Estado(@NotBlank String nome, @NotNull Pais pais) {
		super();
		this.nome=nome;
		this.pais=pais;
	}

	public Estado() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}

	public Estado ValidaEstado(EntityManager manager, Long idEstado) {
		
		Estado estado;
		if (idEstado != null && idEstado != 0) {
			estado = manager.find(Estado.class, idEstado);
			if (estado == null) {
				throw new ApiErroException(HttpStatus.UNPROCESSABLE_ENTITY, "Estado não cadastrado.");
			}

			if (pais.getId() != estado.getPais().getId()) {
				throw new ApiErroException(HttpStatus.UNPROCESSABLE_ENTITY,
						"Estado " + estado.getNome() + " não pertence ao País " + pais.getNome() + ".");
			}
		} else {
			estado = null;
		}

		return estado;
	}
	
}
