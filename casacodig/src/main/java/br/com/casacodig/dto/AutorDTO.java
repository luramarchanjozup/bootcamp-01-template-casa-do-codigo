package br.com.casacodig.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import br.com.casacodig.model.Autor;
import br.com.casacodig.validator.ValorUnico;

//Contagem de Pontos - TOTAL:1
//1 - Autor

public class AutorDTO {
	
	@NotBlank(message = "Coloque o nome, campo Obrigatório.")
	private String nome;
	@NotBlank @Email @ValorUnico(classe = Autor.class, campo = "email")
	private String email;
	@NotBlank @Size(max = 400)
	private String descricao;
	
	public AutorDTO(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	public Autor toModel() {
		return new Autor(this.nome,this.email,this.descricao);
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
}
