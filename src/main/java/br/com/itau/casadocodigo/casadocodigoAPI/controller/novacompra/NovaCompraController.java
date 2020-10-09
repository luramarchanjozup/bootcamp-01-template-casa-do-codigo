package br.com.itau.casadocodigo.casadocodigoAPI.controller.novacompra;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.EstadoObrigatorioValidator;
import br.com.itau.casadocodigo.casadocodigoAPI.controller.form.NovaCompraForm;
import br.com.itau.casadocodigo.casadocodigoAPI.model.NovaCompra;
import br.com.itau.casadocodigo.casadocodigoAPI.model.NovaCompraDetalhesResponse;
import br.com.itau.casadocodigo.casadocodigoAPI.model.NovaCompraItensCarrinho;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Cupom;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Estado;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Pais;
import br.com.itau.casadocodigo.casadocodigoAPI.repository.CupomRepository;
import br.com.itau.casadocodigo.casadocodigoAPI.repository.LivroRepository;
import br.com.itau.casadocodigo.casadocodigoAPI.repository.NovaCompraDetalhesRepository;
import br.com.itau.casadocodigo.casadocodigoAPI.repository.NovaCompraRepository;

@RestController
@RequestMapping(value = "casadocodigo/compras/")
public class NovaCompraController {

	// 1
	private EstadoObrigatorioValidator estadoObrigatorioValidator;

	@PersistenceContext
	private EntityManager entityManager;

	private NovaCompraRepository novaCompraRepository;

	private NovaCompraDetalhesRepository novaCompraDetalhesRepository;

	public NovaCompraController(EstadoObrigatorioValidator estadoObrigatorioValidator,
			NovaCompraRepository novaCompraRepository, NovaCompraDetalhesRepository novaCompraDetalhesRepository) {
		this.estadoObrigatorioValidator = estadoObrigatorioValidator;
		this.novaCompraRepository = novaCompraRepository;
		this.novaCompraDetalhesRepository = novaCompraDetalhesRepository;
	}

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(estadoObrigatorioValidator);
	}

	@PostMapping(value = "inserirNovaCompra")
	@Transactional
	// 1
	public ResponseEntity<String> inserirNovaCompra(@RequestBody(required = true) @Valid NovaCompraForm novaCompraForm,
			UriComponentsBuilder uriBuilder) {

		// 1
		Pais pais = (Pais) entityManager.createQuery("select p from Pais p where p.nome = ?1")
				.setParameter(1, novaCompraForm.getPais()).getResultList().get(0);
		// 1
		Estado estado = (Estado) entityManager.createQuery("select e from Estado e where e.nome = ?1")
				.setParameter(1, novaCompraForm.getEstado()).getResultList().get(0);

		// 1
		NovaCompra novaCompra = novaCompraForm.converter(pais, estado);

		Map<String, BigDecimal> valorAPagar = novaCompraForm.getCarrinhoComprasForm().verificaDesconto(entityManager);

		novaCompra.setValorSemDesconto(valorAPagar.get("ValorSemDesconto"));
		novaCompra.setValorComDesconto(valorAPagar.get("ValorComDesconto"));

		entityManager.persist(novaCompra);

		novaCompraForm.insereItensCarrinhoNovaCompra(entityManager, novaCompra);

		URI uri = uriBuilder.path("casadocodigo/compras/detalhesCompras/{id}").buildAndExpand(novaCompra.getId())
				.toUri();
		return ResponseEntity.created(uri).body("O detalhes da compra estão disponíveis em: " + uri.toString());

	}

	@GetMapping(value = "detalhesCompras/{id}")
	@Transactional
	public ResponseEntity<NovaCompraDetalhesResponse> buscarDetalhesCompra(@PathVariable(required = true) int id) {

		Optional<NovaCompra> compra = novaCompraRepository.findById(id);
		// 1
		Optional<List<NovaCompraItensCarrinho>> itensCarrinho = novaCompraDetalhesRepository.findByNovaCompra_Id(id);

		// 1
		if (!compra.isPresent() || !itensCarrinho.isPresent())
			return ResponseEntity.badRequest().build();

		return ResponseEntity.ok(new NovaCompraDetalhesResponse(compra != null ? compra.get() : null,
				itensCarrinho != null ? itensCarrinho.get() : null));

	}

}
