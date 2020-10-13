package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entities.categoria.Categoria;
import br.com.zup.treinocasadocodigo.entities.categoria.CategoriaNovoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 * Contagem de carga intrínseca da classe: 2
 */

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    //1
    public String cadastroCategorias(@RequestBody @Valid CategoriaNovoRequest novaCategoria) {

        //1
        Categoria categoria = novaCategoria.toModel();
        manager.persist(categoria);
        return categoria.toString();
    }
}
