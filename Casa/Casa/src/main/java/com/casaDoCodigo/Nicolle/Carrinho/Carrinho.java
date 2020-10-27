package com.casaDoCodigo.Nicolle.Carrinho;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.util.Assert;

import com.casaDoCodigo.Nicolle.Compra.ItemCompra;
import com.casaDoCodigo.Nicolle.Livro.Livro;
import com.casaDoCodigo.Nicolle.Livro.LivroRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Carrinho {

	private Set<LivroCarrinho> livros = new LinkedHashSet<>();
	
	@Deprecated
	public Carrinho() {}

	public void adiciona(Livro livro) {
		LivroCarrinho novoItem = new LivroCarrinho(livro);
		boolean result = livros.add(novoItem);	
		if(!result) {
			LivroCarrinho itemExistente = livros.stream().filter(novoItem :: equals).findFirst().get();
			itemExistente.incrementar();
		}
	}

	@Override
	public String toString() {
		return "Carrinho [livros=" + livros + "]";
	}

	public Set<LivroCarrinho> getLivros() {
		return livros;
	}
	
	
	//Possível Json carrinho criado
	
	public static Carrinho Cria(Optional<String> jsonCarrinho) {
		return jsonCarrinho.map(json -> {
			System.out.println("ow");
			try {
				return new ObjectMapper().readValue(json, Carrinho.class);
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e);
			}
		}).orElse(new Carrinho());
		
	}

	public void atualizar(@NotNull Livro livro, @Positive int novaQuantidade) {
		Assert.isTrue(novaQuantidade > 0,"A quantidade deve ser maior que zero");
		LivroCarrinho possivelItemAdicionado = new LivroCarrinho(livro);
		Optional<LivroCarrinho> possivelItem = livros.stream().filter(possivelItemAdicionado :: equals).findFirst();
		
		Assert.isTrue(possivelItem.isPresent(), "Não é possível atualizar o item, não está disponível no carrinho");
		
		LivroCarrinho itemQueExiste = possivelItem.get();
		itemQueExiste.atualizarQuantidade(novaQuantidade);		
	}

	public BigDecimal getTotal() {
		return livros.stream().map(item -> item.getTotal()).reduce(BigDecimal.ZERO, (atual, proximo) -> atual.add(proximo));
	}

	public Set<ItemCompra> geraCompra(LivroRepository livroRepository) {	
		return this.livros.stream().map(itemCarrinho -> {
			return itemCarrinho.novoItemCompra(livroRepository);
		}).collect(Collectors.toSet());
	}
	
	
	/*public static Carrinho exclui(Optional<String> of) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
