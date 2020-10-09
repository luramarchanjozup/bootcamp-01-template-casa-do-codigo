package br.com.itau.casadocodigo.casadocodigoAPI.controller.locais;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.itau.casadocodigo.casadocodigoAPI.config.validacao.EstadoObrigatorioValidator;
import br.com.itau.casadocodigo.casadocodigoAPI.controller.form.AutorForm;
import br.com.itau.casadocodigo.casadocodigoAPI.controller.form.EstadoForm;
import br.com.itau.casadocodigo.casadocodigoAPI.controller.form.PaisForm;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Autor;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Estado;
import br.com.itau.casadocodigo.casadocodigoAPI.model.Pais;
import br.com.itau.casadocodigo.casadocodigoAPI.model.dto.EstadoDTO;
import br.com.itau.casadocodigo.casadocodigoAPI.model.dto.PaisDTO;
import br.com.itau.casadocodigo.casadocodigoAPI.repository.PaisRepository;
import br.com.itau.casadocodigo.casadocodigoAPI.repository.EstadoRepository;

@RestController
@RequestMapping(value = "casadocodigo/locais/")
public class LocaisController {

	// 1
	private PaisRepository paisRepository;
	// 1
	private EstadoRepository estadoRepository;

	public LocaisController(PaisRepository paisRepository, EstadoRepository estadoRepository) {

		this.paisRepository = paisRepository;
		this.estadoRepository = estadoRepository;

	}

	@PostMapping(value = "criarPais")
	@Transactional
	// 1
	public ResponseEntity<PaisDTO> criarPais(@RequestBody(required = true) @Valid PaisForm paisForm,
			UriComponentsBuilder uriBuilder) {

		// 1
		Pais pais = paisForm.converter();
		paisRepository.save(pais);

		URI uri = uriBuilder.path("/paises/{id}").buildAndExpand(pais.getId()).toUri();
		return ResponseEntity.created(uri).body(new PaisDTO(pais.getId(), pais.getNome()));

	}

	@PostMapping(value = "criarEstado")
	@Transactional
	// 1
	public ResponseEntity<EstadoDTO> criarEstado(@RequestBody(required = true) @Valid EstadoForm estadoForm,
			UriComponentsBuilder uriBuilder) {

		Optional<Pais> pais = paisRepository.findByNome(estadoForm.getPais());
		// 1
		Estado estado = estadoForm.converter(pais.isPresent() ? pais.get() : null);
		estadoRepository.save(estado);

		URI uri = uriBuilder.path("/estados/{id}").buildAndExpand(estado.getId()).toUri();
		return ResponseEntity.created(uri).body(new EstadoDTO(estado.getId(), estado.getNome()));

	}

}
