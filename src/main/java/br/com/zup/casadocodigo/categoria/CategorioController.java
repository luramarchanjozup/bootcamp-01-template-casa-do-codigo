package br.com.zup.casadocodigo.categoria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategorioController {
	
	@PersistenceContext
	private EntityManager bancoDados;
	
	
	@PostMapping(value = "/categoria", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public ResponseEntity<CategoriaDTO> cadastrarCategoria(@RequestBody @Valid CategoriaDTO dadosCategoria) {
		
		Categoria categoriaSalva = dadosCategoria.gerarCategoria();
		bancoDados.persist(categoriaSalva);
		CategoriaDTO dadosCategoriaDTO = categoriaSalva.converteCategoriaDTO();
		
		return new ResponseEntity<CategoriaDTO> (dadosCategoriaDTO, HttpStatus.CREATED);
		
	}

}
