package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.services;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.repositories.LivroRepository;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests.NovoLivroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;

    //Valida dados de um novo Livro
    public boolean validaNovoLivro(NovoLivroRequest novoLivroRequest) {

        return true;
    }

    public boolean validaCategoriaExistente(String categoria){

        return false;
    }

}
