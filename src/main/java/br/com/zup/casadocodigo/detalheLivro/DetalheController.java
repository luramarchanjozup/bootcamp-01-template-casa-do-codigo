package br.com.zup.casadocodigo.detalheLivro;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.livro.Livro;

@RestController
public class DetalheController {

	@PersistenceContext
	private EntityManager bancoDados;

	@GetMapping(value = "/livros/detalheLivros", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DetalheLivroResponseDTO>> listaLivros() {
		List<Livro> geraLivro = bancoDados.createQuery("select l from Livro l", Livro.class).getResultList();

		List<DetalheLivroResponseDTO> resultadoLivro = new ArrayList<>();
		for (Livro livro : geraLivro) {
			DetalheLivroResponseDTO converteDados = new DetalheLivroResponseDTO(livro);
			resultadoLivro.add(converteDados);
		}

		return ResponseEntity.ok(resultadoLivro);

	}
}
