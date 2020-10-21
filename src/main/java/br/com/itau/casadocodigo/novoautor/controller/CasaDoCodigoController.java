package br.com.itau.casadocodigo.novoautor.controller;

import br.com.itau.casadocodigo.novoautor.model.Autor;
import br.com.itau.casadocodigo.novoautor.model.AutorRequest;
import br.com.itau.casadocodigo.novoautor.model.AutorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CasaDoCodigoController {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Contagem de carga intrínseca no Controller: 3
     * @param autorRequest recebe na entrada: nome, email e descricao
     * @return um Json de id, nome e data/hora
     */
    @PostMapping(value = "/v1/casadocodigo")
    @Transactional
    public ResponseEntity<AutorResponse> gravar(@RequestBody @Valid AutorRequest autorRequest){
        Autor autor = autorRequest.toModel();

        entityManager.persist(autor);
        return ResponseEntity.status(HttpStatus.OK).body(new AutorResponse(autor));
    }
}
