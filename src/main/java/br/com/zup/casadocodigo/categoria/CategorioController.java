package br.com.zup.casadocodigo.categoria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//2
public class CategorioController {

	@PersistenceContext
	private EntityManager bancoDados;

	@PostMapping(value = "/categoria", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	// 1
	// 1
	public ResponseEntity<Categoria> cadastrarCategoria(@RequestBody @Valid CategoriaDTO dadosCategoria) {

		Categoria categoriaSalva = dadosCategoria.gerarCategoria();
		bancoDados.persist(categoriaSalva);

		return new ResponseEntity<Categoria>(categoriaSalva, HttpStatus.CREATED);

	}

}
