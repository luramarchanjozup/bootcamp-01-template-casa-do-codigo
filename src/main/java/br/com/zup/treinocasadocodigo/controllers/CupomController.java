package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entities.cupom.Cupom;
import br.com.zup.treinocasadocodigo.entities.cupom.CupomAtualizadoRequest;
import br.com.zup.treinocasadocodigo.entities.cupom.CupomNovoRequest;
import br.com.zup.treinocasadocodigo.repository.CupomRepository;
import br.com.zup.treinocasadocodigo.validators.ErroPadronizado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Contagem de carga intrínseca da classe: 7
 */

@RestController
@RequestMapping("/cupons")
public class CupomController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    //1
    CupomRepository cupomRepository;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    //1
    public String cadastroCupom(@RequestBody @Valid CupomNovoRequest novoCupom) {
        //1
        Cupom cupom = novoCupom.toModel();
        manager.persist(cupom);
        return cupom.toString();
    }

    @PutMapping("/{id}")
    @Transactional
    //1
    public ResponseEntity<Object> atualizarCupom(@PathVariable("id") Long id, @RequestBody @Valid CupomAtualizadoRequest cupomAtualizado) {

        Cupom cupom = manager.find(Cupom.class, id);
        //1
        if (cupom == null) {
            return ResponseEntity.notFound().build();
        }

        List<Cupom> listaCupons = cupomRepository.findByCodigo(cupomAtualizado.getCodigo());

        Assert.isTrue(listaCupons.size() <= 1, "Não deveria haver dois codigos iguais");

        //1
        if(!listaCupons.isEmpty() && !listaCupons.get(0).getId().equals(id)) {
            Collection<String> mensagens = new ArrayList<>();
            mensagens.add("Campo codigo já cadastrado");
            //1
            ErroPadronizado erro = new ErroPadronizado(mensagens);
            return ResponseEntity.badRequest().body(erro);
        }

        cupom.autalizar(cupomAtualizado);
        manager.persist(cupom);
        return ResponseEntity.ok().body(cupom);
    }
}