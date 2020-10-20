package io.github.evertoncnsouza.rest.controller;

import io.github.evertoncnsouza.rest.dto.AutorRequest;
import io.github.evertoncnsouza.validation.constraint.valitation.EmailValidator;
import io.github.evertoncnsouza.domain.entity.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;


//4 PCI's
@RestController //Combinação de @Controller e @ResponseBody;
@RequestMapping("api/autores") //Para mapear as solicitações da web;
public class AutorController {
    @PersistenceContext //Funciona como um container que guarda as entidades que estão sendo gerenciadas pelo EntityManager;
    private EntityManager manager; //Realiza operações de sincronismo com o Banco de dados;

    @Autowired //Injeção de dependência;
    private EmailValidator emailvalidator; //PCI 1;

    @InitBinder //Identifica os métodos que inicializam o WebDataBinder, chama a clase e pergunta o formato de validação;
    public void init(WebDataBinder binder) { //Método init, inicializa o WebDataBinder, usado para prencher campos do objeto de comando;
        binder.addValidators(emailvalidator); //PCI 2;
    }

    @PostMapping //Solicitações POST em HTTP.
    @Transactional //Para tudo ou nada. Se o processo for executado,será executado com êxito.
    /*@ResponseStatus(HttpStatus.CREATED) Comentado para retornar o status pedido, 200*/
        public String save (@RequestBody @Valid AutorRequest request){ //PCI 3;
            Autor autor = request.toModel();
            manager.persist(autor); //PCI 4;
            return autor.toString();
    //Neste método, é chamado ToModel da classe AutorRequest e retorna o Json; Esta conversão se chama RequestValueObjects;
    // Requestbody, Diz que a String retornada é o corpo da nossa resposta;
    //Valid- Diz que o dado retornado precisa ser válido;



     }

}
