package br.com.zup.casadocodigo.novacompra;

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

import br.com.zup.casadocodigo.validacao.CupomValidoValidador;
import br.com.zup.casadocodigo.validacao.EstadoPertencePaisValidator;
import br.com.zup.casadocodigo.validacao.ValidadorCpfCnpj;

//5
@RestController
public class NovaCompraController {

	@PersistenceContext
	private EntityManager bancoDados;

	// 1
	@Autowired
	private EstadoPertencePaisValidator estadoPertencePaisValidador;

	// 1
	@Autowired
	private CupomValidoValidador cupomValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		// 1
		binder.addValidators(new ValidadorCpfCnpj(), estadoPertencePaisValidador, cupomValidator);
	}

	// 1
	// 1
	@PostMapping(value = "/compra", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public ResponseEntity<Compra> registrarCompra(@RequestBody @Valid NovaCompraDTO dadosNovaCompra) {
		Compra novaCompra = dadosNovaCompra.gerarNovaCompra(bancoDados);
		bancoDados.persist(novaCompra);
		return new ResponseEntity<Compra>(novaCompra, HttpStatus.CREATED);

	}
}
