package com.casadocodigo.casadocodigo.DetalhesLivro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.casadocodigo.casadocodigo.Livro.Livro;

@RestController
public class DetalheLivrosController {

	@PersistenceContext
	private EntityManager manager;

	@GetMapping("/detalheLivro/{id}")
	public ResponseEntity<?> detalheLivro(@PathVariable Long id) {
		Livro buscarInformacoes = manager.find(Livro.class, id);
		if (buscarInformacoes == null) {
			return ResponseEntity.notFound().build();
		}
		DetalheLivro exibirDetalhe = new DetalheLivro(buscarInformacoes);
		return ResponseEntity.ok(exibirDetalhe);
	}
}
