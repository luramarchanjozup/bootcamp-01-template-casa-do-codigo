package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entities.DadosCompradorRequest;
import br.com.zup.treinocasadocodigo.entities.autor.Autor;
import br.com.zup.treinocasadocodigo.entities.estado.Estado;
import br.com.zup.treinocasadocodigo.entities.pais.Pais;
import br.com.zup.treinocasadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;

/**
 * Contagem de carga intrínseca da classe: 7
 */

@RestController
public class CompraController {

    @Autowired
    EstadoRepository estadoRepository;

    @PersistenceContext
    EntityManager manager;

    @PostMapping("/comprador")
    //1
    public String dadosComprador(@RequestBody @Valid DadosCompradorRequest dadosComprador) {

        //1
        Pais pais = manager.find(Pais.class, dadosComprador.getIdPais());
        List<Estado> buscaEstado = estadoRepository.findByPais(pais);

        //2
        if (dadosComprador.getIdEstado() == null) {
            //1
            if (!buscaEstado.isEmpty()) {
                return "Estado inválido";
            }
        } else {

            //1
            Estado estado = manager.find(Estado.class, dadosComprador.getIdEstado());
            long filtro = buscaEstado.stream().filter(estado::equals).count();

            //1
            if (filtro == 0) {
                return "Estado inválido";
            }
        }

        return dadosComprador.toString();
    }
}
