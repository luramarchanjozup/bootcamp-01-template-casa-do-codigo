package io.github.evertoncnsouza.rest.controller;

import io.github.evertoncnsouza.rest.dto.CategoriaRequest;
import io.github.evertoncnsouza.domain.entity.Categoria;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

//2 PCI's
@RestController
@RequestMapping("api/categorias")
public class CategoriaController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    //@ResponseStatus(HttpStatus.CREATED) Comentado para retornar 200;
    public String save (@RequestBody @Valid CategoriaRequest request) {
        Categoria categoria = new Categoria(request.getNome());
        manager.persist(categoria);
        return categoria.toString();
    }
    //PCI 1- Categoria Request;
    //PCI 2- Categoria;
    //Comentários sobre annotations feitos na classe Autor;
    //Este modelo de conversão não está no padrão do mercado, porém creio que não há problemas usando apenas um get.
}
