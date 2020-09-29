package com.github.marcoscoutozup.casadocodigo.pagamento;

import com.github.marcoscoutozup.casadocodigo.estado.Estado;
import com.github.marcoscoutozup.casadocodigo.pais.Pais;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public String fluxoDePagamento(@RequestBody @Valid PessoaDTO pessoaDto){
        Pais pais = entityManager.find(Pais.class, pessoaDto.getPais());
        if(pessoaDto.getEstado() != null){
            pais.validaSeEstadoPertenceAoPais(pessoaDto.getEstado());
            Estado estado = entityManager.find(Estado.class, pessoaDto.getEstado());
        }
        return "";
    }

}
