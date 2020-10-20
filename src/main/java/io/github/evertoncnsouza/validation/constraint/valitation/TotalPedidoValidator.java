package io.github.evertoncnsouza.validation.constraint.valitation;

import io.github.evertoncnsouza.domain.entity.Livro;
import io.github.evertoncnsouza.rest.dto.CompraRequest;
import io.github.evertoncnsouza.rest.dto.PedidoItemRequest;
import io.github.evertoncnsouza.rest.dto.PedidoRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;

@Component
public class TotalPedidoValidator implements Validator {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> clazz) {
        return CompraRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors())
            return;
        PedidoRequest request = ((CompraRequest) target).getPedido();
        BigDecimal total = BigDecimal.ZERO;

        for (PedidoItemRequest item : request.getItens()) {
            Livro livro = entityManager.find(Livro.class, item.getIdLivro());
            Assert.notNull(livro, "Livro não encontrado para o id: " + item.getIdLivro());
            total = new BigDecimal(item.getQuantidade()).multiply(livro.getPreco());
        }

        if(total.compareTo(request.getTotal()) != 0) {
            errors.rejectValue("pedido.total", null, "O valor total não condiz com os itens solicitados");
        }

    }

}

