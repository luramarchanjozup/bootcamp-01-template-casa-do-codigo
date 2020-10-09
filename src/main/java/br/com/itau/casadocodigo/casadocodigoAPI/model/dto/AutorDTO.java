package br.com.itau.casadocodigo.casadocodigoAPI.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AutorDTO {

	private int id;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime instanteRegistro = LocalDateTime.now();
	private String nome;
	private String email;
	private String descricao;

	@Deprecated
	public AutorDTO() {

	}

	public AutorDTO(int id, String nome, String email, String descricao) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getInstanteRegistro() {
		return instanteRegistro;
	}

	public void setInstanteRegistro(LocalDateTime instanteRegistro) {
		this.instanteRegistro = instanteRegistro;
	}

	@Override
	public String toString() {
		return "AutorDTO [id=" + id + ", instanteRegistro=" + instanteRegistro + ", nome=" + nome + ", email=" + email
				+ ", descricao=" + descricao + "]";
	}

}
