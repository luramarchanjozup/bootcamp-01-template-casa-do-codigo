package com.casaDoCodigo.Nicolle.Carrinho;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casaDoCodigo.Nicolle.Livro.Livro;
import com.casaDoCodigo.Nicolle.Livro.LivroRepository;
import com.casaDoCodigo.Nicolle.Shared.Cookies;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class CarrinhoController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private Cookies cookies;
	
	@PostMapping(value = "/casa/carrinho/{idLivro}")
	public String adicionaLivroCarrinho(@PathVariable("idLivro") Long idLivro, @CookieValue("carrinho") Optional<String> jsonCarrinho,HttpServletResponse response) throws JsonProcessingException {
	
		Carrinho carrinho = Carrinho.Cria(jsonCarrinho);		
		carrinho.adiciona(livroRepository.findById(idLivro).get());
		cookies.writesAsJson("carrinho",carrinho,response);
			
		return carrinho.toString();
	}
	
	@PostMapping(value = "/casa/carrinho/{idLivro}/atualizar")
	public void atualizar(@PathVariable("idLivro") Long idLivro,@RequestParam int novaQuantidade, @CookieValue("carrinho") String jsonCarrinho,HttpServletResponse response) {
		Carrinho carrinho = Carrinho.Cria(Optional.of(jsonCarrinho));
		Livro livro = livroRepository.findById(idLivro).get();
		
		carrinho.atualizar(livro,novaQuantidade);
		cookies.writesAsJson("carrinho", carrinho, response);	
	}
	
	/*@DeleteMapping(value = "/casa/carrinho/{idLivro}/Excluir")
	public void excluir(@PathVariable("idLivro") Long idLivro, @CookieValue("carrinho") String jsonCarrinho,HttpServletResponse response) {
		Carrinho carrinho = Carrinho.exclui(Optional.of(jsonCarrinho));
		
		//if(!livroRepository.existsById(idLivro)) {}
		
		}*/
	

}