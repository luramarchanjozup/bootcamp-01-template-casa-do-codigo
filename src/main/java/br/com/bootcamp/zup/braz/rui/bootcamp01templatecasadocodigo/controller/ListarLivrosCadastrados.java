package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.controller;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RestController
@RequestMapping(value = "/listarLivros")
public class ListarLivrosCadastrados {

    @Autowired
    EntityManager entityManager;

    @GetMapping
    @ResponseBody //1
    public List<Livro> listarLivros(){
        Query query = entityManager.createQuery("select l from " + Livro.class.getName() + " l");
        List<Livro> resultado = query.getResultList();
        return resultado;
    }
}
