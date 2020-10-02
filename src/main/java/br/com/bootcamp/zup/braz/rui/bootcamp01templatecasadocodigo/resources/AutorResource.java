package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.resources;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.repositories.AutorRepository;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests.AutorRequest;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequestMapping(value = "/autor")
public class AutorResource {

    @Autowired
    AutorService autorService;

    //Cadastrar um novo Autor
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public ResponseEntity<Void> cadastrarAutor(@Validated @RequestBody AutorRequest autorRequest){

        autorService.cadastrar(autorRequest.getNome(), autorRequest.getEmail(), autorRequest.getDescricao(), LocalDateTime.now());
        return ResponseEntity.ok().build();
    }
}
