package br.com.zup.casadocodigo.paisestado;

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
public class PaisController {

	@PersistenceContext
	private EntityManager bancoDados;

	// 1
	// 1
	@PostMapping(value = "/pais")
	@Transactional
	public ResponseEntity<Pais> cadastrarPais(@RequestBody @Valid PaisDTO dadosPais) {
		Pais novoPais = dadosPais.gerarNovoPais();
		bancoDados.persist(novoPais);
		return new ResponseEntity<Pais>(novoPais, HttpStatus.CREATED);

	}

}
