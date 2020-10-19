package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.domain.Buyer;
import br.com.zup.casadocodigo.dto.DetailsBuyDTO;
import br.com.zup.casadocodigo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/detailBuy")
public class DetailsBuy {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping(value = "/{id}")
    @Transactional
    public DetailsBuyDTO detailsBuy(@PathVariable("id") Long id) {
        var buy = entityManager.find(Buyer.class, id);

        return(DetailsBuyDTO.toModel(buy, orderRepository));
    }
}
