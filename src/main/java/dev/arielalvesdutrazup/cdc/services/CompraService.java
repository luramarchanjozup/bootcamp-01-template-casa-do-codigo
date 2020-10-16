package dev.arielalvesdutrazup.cdc.services;

import dev.arielalvesdutrazup.cdc.controllers.dtos.CompraItemRequestDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.CompraRequestDTO;
import dev.arielalvesdutrazup.cdc.entities.*;
import dev.arielalvesdutrazup.cdc.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class CompraService {

    @Autowired
    private PaisService paisService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private LivroService livroService;

    @Autowired
    private CupomService cupomService;

    @Autowired
    private CompraRepository compraRepository;

    @Transactional
    public Compra fecharCompra(CompraRequestDTO requestDTO) {
        Compra compraParaCadastrar = requestDTO.paraEntidade();

        Pais pais = paisService.buscaPeloId(requestDTO.getPaisId());
        Set<CompraItem> itens = montaItens(requestDTO.getItens());

        compraParaCadastrar.setPais(pais);
        compraParaCadastrar.setItens(itens);

        if (requestDTO.getEstadoId() != null) {
            Estado estado = estadoService.buscaPeloIdEPaisId(requestDTO.getEstadoId(), pais.getId());
            compraParaCadastrar.setEstado(estado);
        }

        if (requestDTO.getCupomCodigo() != null) {
            Cupom cupom = cupomService.buscaPeloCodigo(requestDTO.getCupomCodigo());
            compraParaCadastrar.aplicaCupom(cupom);
        }


        return compraRepository.save(compraParaCadastrar);
    }

    public Compra buscaPeloId(Long id) {
        return compraRepository.findFetchById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Compra com id " + id + " não localizada!"));
    }

    private Set<CompraItem> montaItens(Set<CompraItemRequestDTO> itensDTO) {
        Assert.notNull(itensDTO, "É obrigatório ao menos 1 item de compra!");
        Set<CompraItem> itens = new HashSet<>();
        itensDTO.forEach(itemDTO -> {
            Livro livro = livroService.buscaPeloId(itemDTO.getLivroId());
            Integer quantidade = itemDTO.getQuantidade();
            CompraItem item = new CompraItem()
                    .setLivro(livro)
                    .setQuantidade(quantidade);
            itens.add(item);
        });

        return itens;
    }
}
