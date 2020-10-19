package br.com.zup.casadocodigo.detalhelivro;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.livro.Livro;

@RestController
public class DetalheController {

	@PersistenceContext
	private EntityManager bancoDados;

	@GetMapping(value = "/livro/detalheLivro/lista", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DetalheLivroResponseDTO>> listaLivros() {
		List<Livro> geraLivro = bancoDados.createQuery("select l from Livro l", Livro.class).getResultList();

		List<DetalheLivroResponseDTO> resultadoLivro = new ArrayList<>();
		for (Livro livro : geraLivro) {
			DetalheLivroResponseDTO converteDados = new DetalheLivroResponseDTO(livro);
			resultadoLivro.add(converteDados);
		}

		return ResponseEntity.ok(resultadoLivro);

	}

	@GetMapping(value = "/livro/detalheLivro/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DetalheLivroResponseDTO> buscarDetalheLivros(@PathVariable("id") Long id) {
		Livro livroBuscado = bancoDados.find(Livro.class, id);

		if (livroBuscado == null) {
			return ResponseEntity.notFound().build();
		}

		DetalheLivroResponseDTO detalheLivroResponseDTO = new DetalheLivroResponseDTO(livroBuscado);
		return ResponseEntity.ok(detalheLivroResponseDTO);
	}

}