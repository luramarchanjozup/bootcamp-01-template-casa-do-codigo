package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.services;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Autor;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.repositories.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServico {

    @Autowired
    private AutorRepositorio autorRepositorio;

    //Cadastrar um novo Autor
    public Autor cadastrar(String nome, String email, String descricao){
        Autor autor = new Autor(nome, email, descricao);
        autorRepositorio.save(autor);
        return autor;
    }
}
