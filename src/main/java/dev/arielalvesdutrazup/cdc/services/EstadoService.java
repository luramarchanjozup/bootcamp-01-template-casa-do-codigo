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

// 1 PaisService.java
// 2 EstadoRepository.java
// 3 Estado.java
// 4 Pais.java
// 5 if (existeEstado) throw new EntityExistsException("Nome duplicado!");
// 6 estadoRepository.findByIdAndPaisId(estadoId, paisId).orElseThrow(()
// 7 estadoRepository.findByNomeAndPais(nome, pais).orElseThrow(()
@Service
public class EstadoService {

    @Autowired
    private PaisService paisService;

    @Autowired
    private EstadoRepository estadoRepository;

    @Transactional
    public Estado cadastrar(Long paisId, Estado estadoParaCadastrar) {
        Assert.notNull(paisId, "Id do país não pode ser nulo!");
        Pais pais = paisService.buscaPeloId(paisId);

        boolean existeEstado = existePeloNomeEPaisId(estadoParaCadastrar.getNome(), pais.getId());

        if (existeEstado) throw new EntityExistsException("Nome duplicado!");

        estadoParaCadastrar.setPais(pais);
        return estadoRepository.save(estadoParaCadastrar);
    }

    public Estado buscaPeloIdEPaisId(Long estadoId, Long paisId) {
        Assert.notNull(estadoId, "Id do estado é obrigatório para a busca!");
        Assert.notNull(paisId, "Id do pais é obrigatório para a busca!");

        return estadoRepository.findByIdAndPaisId(estadoId, paisId)
                .orElseThrow(() -> new EntityNotFoundException("Estado com id " + estadoId + " não localizado!"));
    }

    public Estado buscaPeloNomeEPais(String nome, Pais pais) {
        Assert.notNull(nome, "Nome do estado é obrigatório para a busca!");
        Assert.notNull(pais, "País do estado é obrigatório para a busca!");

        return estadoRepository.findByNomeAndPais(nome, pais)
                .orElseThrow(() -> new EntityNotFoundException("Estado com nome " + nome + " não localizado!"));
    }

    public boolean existePeloNomeEPaisId(String nome, Long paisId) {
        Assert.notNull(nome, "Nome do estado é obrigatório para a busca!");
        Assert.notNull(paisId, "Id do pais é obrigatório para a busca!");

        return estadoRepository.existsByNomeAndPaisId(nome, paisId);
    }

    @Transactional
    public void removeTodos() {
        estadoRepository.deleteAll();
    }
}
