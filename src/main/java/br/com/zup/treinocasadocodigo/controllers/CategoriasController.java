package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entities.Categoria;
import br.com.zup.treinocasadocodigo.entities.CategoriaNovoRequest;
import br.com.zup.treinocasadocodigo.validators.CategoriaValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 * Contagem de carga intrínseca da classe: 3
 */

@RestController
public class CategoriasController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    //1
    private CategoriaValidador categoriaValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(categoriaValidator);
    }

    @PostMapping(value="/categorias")
    @Transactional
    //1
    public String cadastroCategorias(@RequestBody @Valid CategoriaNovoRequest novaCategoria) {

        //1
        Categoria categoria = novaCategoria.toModel();
        manager.persist(categoria);
        return categoria.toString();
    }
}
