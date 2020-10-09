package com.example.apicasadocodigo.fluxocompra.cupom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cupons")
public class CupomController {
    @Autowired
    private CupomRepository cupomRepository;

    @PostMapping
    @Transactional
    public String criarCupom(@Valid @RequestBody NovoCupomRequest request) {
        Cupom novoCupom = request.toModel();
        cupomRepository.save(novoCupom);
        return "O cupom de código " + novoCupom.getCodigo() + " foi criado.";
    }

    @PutMapping("/{id}")
    @Transactional
    public String alterarCupom(@PathVariable Long id, @Valid @RequestBody NovoCupomRequest request) {
        Cupom novoCupom = request.toModel();
        Cupom cupomASerAlterado = cupomRepository.getOne(id);
        cupomASerAlterado.setCodigo(novoCupom.getCodigo());
        cupomASerAlterado.setDesconto(novoCupom.getDesconto());
        cupomASerAlterado.setValidade(novoCupom.getValidade());
        cupomRepository.save(cupomASerAlterado);
        return "Cupom de id " + id + " alterado";
    }
}
