package br.com.itau.casadocodigo.cadastrocliente.controller;

import br.com.itau.casadocodigo.cadastrocliente.model.Cliente;
import br.com.itau.casadocodigo.cadastrocliente.model.ClienteRequest;
import br.com.itau.casadocodigo.cadastrocliente.model.ClienteResponse;
import br.com.itau.casadocodigo.cadastrocliente.repository.CupomRepository;
import br.com.itau.casadocodigo.validador.VerificaCupomDesconto;
import br.com.itau.casadocodigo.validador.VerificaPrecoDaCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class CadastroClienteController {

    @Autowired
    private VerificaPrecoDaCompra verificaPrecoDaCompra;

    @Autowired
    private VerificaCupomDesconto verificaCupomDesconto;

    @Autowired
    private CupomRepository cupomRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(verificaPrecoDaCompra, verificaCupomDesconto);
    }

    /**
     * Contagem de carga intrínseca no Controller: 6
     * @param clienteRequest recebe os dados do cliente e da compra
     * @param builder retorna a url da compra
     * @return os dados do cliente e compra salvos no banco
     */
    @PostMapping(value = "/v1/cliente")
    @Transactional
    public ResponseEntity<ClienteResponse> CadastraCliente(@RequestBody @Valid ClienteRequest clienteRequest, UriComponentsBuilder builder) {
        Cliente cliente = clienteRequest.toClienteModel(cupomRepository);
        entityManager.persist(cliente);
        URI enderecoCadastroCliente = builder.path("/v1/cliente/{id}").build(cliente.getId());
        return ResponseEntity.created(enderecoCadastroCliente).body(new ClienteResponse(cliente));
    }

    /**
     * Contagem de carga intrínseca no Controller: 1
     * @param id identificador do cliente
     * @return o Json do cliente
     */
    @GetMapping("/v1/cliente/{id}")
    @Transactional
    public ResponseEntity<ClienteResponse> ExibeCliente(@PathVariable("id") Long id) {
        Cliente cliente = entityManager.find(Cliente.class, id);

        if (cliente == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(new ClienteResponse(cliente));
    }
}
