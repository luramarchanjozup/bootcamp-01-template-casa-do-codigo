package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.services;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Autor;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NovoAutorService {

    @Autowired
    private AutorRepository autorRepository;


    //Cadastrar um novo Autor
    public Autor cadastrar(String nome, String email, String descricao, LocalDateTime registro){

        Autor autor = new Autor(nome, email, descricao, registro);
        autorRepository.save(autor);
        return autor;
    }

}
