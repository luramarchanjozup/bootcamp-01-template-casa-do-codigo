package dev.arielalvesdutrazup.cdc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GerenciadorDeServico {

    @Autowired
    private PaisService paisService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private LivroService livroService;

    @Autowired
    private CupomService cupomService;

    public CupomService instanciaDeCupomService() {
        return cupomService;
    }

    public PaisService instanciaDePaisService() {
        return paisService;
    }

    public EstadoService instanciaDeEstadoService() {
        return estadoService;
    }

    public LivroService instanciaDeLivroService() {
        return livroService;
    }
}
