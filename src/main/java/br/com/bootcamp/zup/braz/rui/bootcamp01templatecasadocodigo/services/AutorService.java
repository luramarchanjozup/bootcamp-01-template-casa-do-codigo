package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.services;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Autor;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.repositories.AutorRepository;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.services.exceptions.ObjetoDuplicadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;


    //Cadastrar um novo Autor
    public Autor cadastrar(String nome, String email, String descricao, LocalDateTime registro){

        Autor autor = new Autor(nome, email, descricao, registro);
        autorRepository.save(autor);
        return autor;
    }

    //Valida email duplicado
    public boolean validaEmailDuplicado(String email){
        if (autorRepository.findByEmail(email) != null){
            return true;
        }
        return false;
    }

}
