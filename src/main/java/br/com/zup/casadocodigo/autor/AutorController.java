package br.com.zup.casadocodigo.autor;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutorController {
	
	@PersistenceContext
	private EntityManager bancoDados;	
	
	@Autowired
	private ValidaEmailDuplicadoAutor validaEmailDuplicadoAutor;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(validaEmailDuplicadoAutor);
	}
	
	
	@PostMapping(value = "/autor", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	//2
	public ResponseEntity<Autor> salvarAutor(@RequestBody @Valid AutorDTO dadosAutor){
		
		Autor novoAutor = dadosAutor.geraNovoAutor();
		bancoDados.persist(novoAutor);
	
		return new ResponseEntity<Autor>(novoAutor, HttpStatus.CREATED);
	}
	
	@GetMapping (value = "/autor/{nomeAutor}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Autor>> procurarAutorNome(@PathVariable String nomeAutor){
		//1
		List<Autor> listaAutores = bancoDados.createQuery("SELECT a FROM Autor a WHERE a.nome LIKE :nome", Autor.class)
											 .setParameter("nome", "%" +nomeAutor+ "%").getResultList();
		
		return ResponseEntity.ok(listaAutores);
		
		}
	

	
	
}
