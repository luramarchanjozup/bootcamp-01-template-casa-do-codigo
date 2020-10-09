package br.com.zup.casadocodigo.autor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutorController {
	
	@PersistenceContext
	private EntityManager bancoDados;	
	
	@PostMapping(value = "/autor", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public ResponseEntity<Autor> salvarAutor(@RequestBody AutorDTO dadosAutor){
		
		Autor novoAutor = dadosAutor.geraNovoAutor();
		bancoDados.persist(novoAutor);
	
		return ResponseEntity.ok(novoAutor);
	}
	

	
	
}
