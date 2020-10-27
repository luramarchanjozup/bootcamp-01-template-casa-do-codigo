package com.casadocodigo.casadocodigo.Estado;

import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.casadocodigo.casadocodigo.Pais.Pais;
import com.casadocodigo.casadocodigo.Validation.ConfirmarExistencia;
import com.casadocodigo.casadocodigo.Validation.ValorUnico;
import com.sun.istack.NotNull;

public class EstadoDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank @ValorUnico(campo = "nome", classe = Estado.class) String nome;
	private @NotNull @ConfirmarExistencia(campo = "id", classe = Pais.class) Long idPais;

	public EstadoDto(@NotBlank String nome, Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}

	public Estado toModel(EntityManager manager) {
		return new Estado(nome, manager.find(Pais.class, idPais));
	}

}
