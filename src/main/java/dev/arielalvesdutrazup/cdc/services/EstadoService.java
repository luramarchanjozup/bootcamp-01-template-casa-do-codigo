package dev.arielalvesdutrazup.cdc.services;

import dev.arielalvesdutrazup.cdc.entities.Estado;
import dev.arielalvesdutrazup.cdc.entities.Pais;
import dev.arielalvesdutrazup.cdc.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Transactional
    public Estado cadastrar(Estado estadoParaCadastrar) {
        try {
            buscaPeloNomeEPais(estadoParaCadastrar.getNome(), estadoParaCadastrar.getPais());
            throw new RuntimeException("Nome duplicado!");
        } catch (EntityNotFoundException e) {
            return estadoRepository.save(estadoParaCadastrar);
        }
    }

    public Estado buscaPeloNomeEPais(String nome, Pais pais) {
        return estadoRepository.findByNomeAndPais(nome, pais)
                .orElseThrow(() -> new EntityNotFoundException("Estado com nome " + nome + " não localizado!"));
    }
}
