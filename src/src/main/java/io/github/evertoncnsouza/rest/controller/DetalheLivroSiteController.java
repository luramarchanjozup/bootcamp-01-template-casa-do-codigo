package io.github.evertoncnsouza.rest.controller;

import io.github.evertoncnsouza.rest.dto.DetalheSiteLivroResponse;
import io.github.evertoncnsouza.domain.entity.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;

//3 PCI's'
@RequestMapping("/api/produtos")
@RestController
public class DetalheLivroSiteController {

    @PersistenceContext //Utilizado para a Query que seleciona os livros.
    private EntityManager manager;

    @GetMapping("{id}") //ResponseEntity é utilizadoem situações que precisamos de mais controle sobre a resposta HTTP.
    public ResponseEntity<?> detalhe(@PathVariable("id") Long id) { //@PathVariable pois o valor da varíavel é passado diretamente na URL.
        Livro livroBuscado = manager.find(Livro.class, id); //PCI 1;
        if (livroBuscado == null) {
            return ResponseEntity.notFound().build();//PCI 2;
        }
        DetalheSiteLivroResponse detalheSiteLivroResponse = new DetalheSiteLivroResponse(
                livroBuscado);
        return ResponseEntity.ok (detalheSiteLivroResponse); //PCI 3;
    }
//Não serializamos objeto de dominio para resposta de API.
	@GetMapping("/lista-tudo")
	public HashMap<String, Object> list() {
		HashMap<String, Object> resultado = new HashMap<>();
		List DetalheSiteLivroResponse = manager.createQuery("select c from Livro c").getResultList();
		resultado.put("livros", DetalheSiteLivroResponse.toString());
		return resultado;
		//PCI 4;
	}
//HashMap, para gerar uma lista com os livros cadastrados.
}
