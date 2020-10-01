package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.resources;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests.AutorRequest;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.services.AutorServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/autor")
public class AutorResource {

    @Autowired
    AutorServico autorServico;

    //Cadastrar um novo Autor
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public ResponseEntity<Void> cadastrarAutor(@RequestBody AutorRequest autorRequest){
        autorServico.cadastrar(autorRequest.getNome(), autorRequest.getEmail(), autorRequest.getDescricao());
        return ResponseEntity.ok().build();
    }
}
