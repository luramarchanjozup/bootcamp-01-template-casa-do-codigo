package br.com.carlos.casadocodigo.domain.service.impl;

import br.com.carlos.casadocodigo.domain.entity.Autor;
import br.com.carlos.casadocodigo.domain.repository.AutorRepository;
import br.com.carlos.casadocodigo.domain.service.CadastroAutorService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroAutorServiceImpl implements CadastroAutorService {

    private AutorRepository autorRepository;

    public CadastroAutorServiceImpl(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }
    @Override
    public Autor salvar(Autor autor) {
        return autorRepository.save(autor);
    }
}
