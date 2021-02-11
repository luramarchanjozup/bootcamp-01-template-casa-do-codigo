package com.casaDoCodigo.Nicolle.Compra;

import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casaDoCodigo.Nicolle.Carrinho.Carrinho;
import com.casaDoCodigo.Nicolle.Cliente.ClienteForm;
import com.casaDoCodigo.Nicolle.Cupom.CupomRepository;
import com.casaDoCodigo.Nicolle.Estado.EstadoRepository;
import com.casaDoCodigo.Nicolle.Livro.LivroRepository;
import com.casaDoCodigo.Nicolle.Pais.PaisRepository;


@RestController
public class CompraController {
	
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CupomRepository cupomRepository;
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	

	
	@PostMapping(value = "/casa/carrinho/comprar")
	@Transactional
	public void comprar(@RequestBody @Valid ClienteForm form, @CookieValue("carrinho") String jsonCarrinho) throws Exception {
		Carrinho carrinho = Carrinho.Cria(Optional.of(jsonCarrinho));
		Set<ItemCompra> itens = carrinho.geraCompra(livroRepository);
		System.out.println(itens);
		Compra novaCompra = form.novaCompra(itens,cupomRepository,estadoRepository,paisRepository);
		
		compraRepository.save(novaCompra);
		
	}
	
	
	@GetMapping(value = "/casa/carrinho/comprar/{id}")
	public ResponseEntity<Compra> Buscar(@PathVariable long id){
	   return compraRepository.findById(id)
	           .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}

}
