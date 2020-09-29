package com.casadocodigo.casadocodigo.Livro;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivrosController {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	@PostMapping("/livros")
	public String cadastrarLivro(@RequestBody @Valid LivroDto dto) {
		Livro novoLivro = dto.toModel(manager);
		manager.persist(novoLivro);
		return novoLivro.toString();
	}

	@GetMapping("/livros")
	public ResponseEntity<?> listaLivro() {
		List<Livro> lista = manager.createQuery("select l from Livro l", Livro.class).getResultList();
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/livros/{id}")
	public ResponseEntity<?> buscarLivro(@PathVariable @Valid Long id) {
		Livro livro = manager.find(Livro.class, id);
		if (livro == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(livro);
	}

}
