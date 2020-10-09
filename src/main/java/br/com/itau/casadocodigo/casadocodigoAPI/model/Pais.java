package br.com.itau.casadocodigo.casadocodigoAPI.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pais")
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	private String nome;
	// 1
	@OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
	private List<Estado> estados;
	@OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
	private List<NovaCompra> clientes;

	public Pais(@NotBlank String nome) {
		this.nome = nome;
	}

	@Deprecated
	public Pais() {

	}

	public int getId() {
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

}
