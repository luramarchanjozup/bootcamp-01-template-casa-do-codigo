package br.com.casacodig.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class ItemCarrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") 
	private Long id;
	@ManyToOne @NotNull
	private Livro livro;
	@Positive
	private int quantidade;
	
	@Deprecated
	public ItemCarrinho() {
	}

	
	public ItemCarrinho(@NotNull Livro livro, @Positive int quantidade) {
		super();
		this.livro = livro;
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "ItemCarrinho [livro=" + livro + ", quantidade=" + quantidade + "]";
	}


	public Livro getLivro() {
		return livro;
	}


	public int getQuantidade() {
		return quantidade;
	}
	
	
	
	
}
