package dev.arielalvesdutrazup.cdc.services;

import dev.arielalvesdutrazup.cdc.entities.Estado;
import dev.arielalvesdutrazup.cdc.entities.Pais;
import dev.arielalvesdutrazup.cdc.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class EstadoService {

    @Autowired
    private PaisService paisService;

    @Autowired
    private EstadoRepository estadoRepository;

    @Transactional
    public Estado cadastrar(Long paisId, Estado estadoParaCadastrar) {
        Assert.notNull(paisId, "O ID do país não pode ser nulo!");
        Pais pais = paisService.buscaPeloId(paisId);

        try {
            buscaPeloNomeEPais(estadoParaCadastrar.getNome(), pais);
            throw new EntityExistsException("Nome duplicado!");
        } catch (EntityNotFoundException e) {
            estadoParaCadastrar.setPais(pais);
            return estadoRepository.save(estadoParaCadastrar);
        }
    }

    public Estado buscaPeloIdEPaisId(Long estadoId, Long paisId) {
        Assert.notNull(estadoId, "Id do estado é obrigatório para a busca!");
        Assert.notNull(paisId, "Id do pais é obrigatório para a busca!");

        return estadoRepository.findByIdAndPaisId(estadoId, paisId)
                .orElseThrow(() -> new EntityNotFoundException("Estado com id " + estadoId + " não localizado!"));
    }

    public Estado buscaPeloNomeEPais(String nome, Pais pais) {
        return estadoRepository.findByNomeAndPais(nome, pais)
                .orElseThrow(() -> new EntityNotFoundException("Estado com nome " + nome + " não localizado!"));
    }

    @Transactional
    public void removeTodos() {
        estadoRepository.deleteAll();
    }
}
