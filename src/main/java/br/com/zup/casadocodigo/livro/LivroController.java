package br.com.zup.casadocodigo.livro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//2
@RestController
public class LivroController {

	@PersistenceContext
	private EntityManager bancoDados;

	// 1
	// 1
	@PostMapping(value = "/livro")
	@Transactional
	public ResponseEntity<Livro> salvarLivro(@RequestBody @Valid LivroDTO dadosLivro) {
		Livro novoLivro = dadosLivro.geraNovoLivro(bancoDados);
		bancoDados.persist(novoLivro);
		return new ResponseEntity<Livro>(novoLivro, HttpStatus.CREATED);
	}

}