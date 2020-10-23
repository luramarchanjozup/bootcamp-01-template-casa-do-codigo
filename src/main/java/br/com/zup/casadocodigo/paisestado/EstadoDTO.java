package br.com.zup.casadocodigo.paisestado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casadocodigo.validacao.IdExiste;
import br.com.zup.casadocodigo.validacao.ValorUnico;

//4
public class EstadoDTO {

	// 1
	// 1
	@NotBlank
	@ValorUnico(classeDominio = Estado.class, nomeCampo = "nome")
	private String nome;

	// 1
	// 1
	@NotNull
	@IdExiste(domainClass = Pais.class, fieldName = "idPais")
	private Integer idPais;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdPais() {
		return idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public Estado gerarNovoEstado(EntityManager bancoDados) {
		Pais buscaPais = bancoDados.find(Pais.class, idPais);

		Estado novoEstado = new Estado(nome, buscaPais);

		return novoEstado;
	}

}
