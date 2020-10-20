package br.com.thyagoribeiro.casadocodigo.validator;

import br.com.thyagoribeiro.casadocodigo.domain.Livro;
import br.com.thyagoribeiro.casadocodigo.rest.contract.NovaCompraRequest;
import br.com.thyagoribeiro.casadocodigo.rest.contract.NovoItemRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

// CDD - Total: 6

@Component
public class ValorTotalValidator implements Validator {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCompraRequest.class.isAssignableFrom(clazz); // CDD 1 - NovaCompraRequest
    }

    @Override
    public void validate(Object target, Errors errors) {

        if(errors.hasErrors()) // CDD 1 - branch if
            return;

        double totalCompra = 0;

        NovaCompraRequest novaCompraRequest = (NovaCompraRequest) target;

        Query query  = entityManager.createQuery("SELECT l FROM Livro l WHERE id = :livroId");

        for(NovoItemRequest novoItemRequest : novaCompraRequest.getPedido().getNovoItemRequestList()) { // CDD 2 - Classe NovoItemRequest e branch for
            query.setParameter("livroId", novoItemRequest.getLivroId());
            Livro livro = (Livro) query.getSingleResult(); // CDD 1 - Classe Livro

            totalCompra += livro.getPreco().doubleValue() * novoItemRequest.getQuantidade();
        }

        if(totalCompra != novaCompraRequest
                .getPedido()
                .getTotal().doubleValue()) // CDD 1 - branch if
            errors.rejectValue("pedido.total", null, "deve ser igual a soma do preço dos itens");

    }
}
