package br.com.carlos.casadocodigo.api.controller;

import br.com.carlos.casadocodigo.api.dto.response.ResponseDetalhesCompraDto;
import br.com.carlos.casadocodigo.domain.entity.Compra;
import br.com.carlos.casadocodigo.domain.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@RestController    
public class DetalhesCompraController {

    @Autowired
    private EntityManager manager;

    @Autowired                  //1
    private PedidoRepository pedidoRepository;

    @Autowired
    private ModelMapper mapper;

    @Transactional
    @GetMapping("detalhescompras/{id}")
            //1
    public ResponseDetalhesCompraDto detalhesCompra(@PathVariable Long id){
                                            //1
        var compra = manager.find(Compra.class, id);
                                            //1
        return (ResponseDetalhesCompraDto.toDto(compra, pedidoRepository));

    }
    
}
