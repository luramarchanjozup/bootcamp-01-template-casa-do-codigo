package br.com.zup.treinocasadocodigo.validators.validarcompras;

import br.com.zup.treinocasadocodigo.entities.compra.Compra;
import br.com.zup.treinocasadocodigo.entities.compra.CompraNovoRequest;
import br.com.zup.treinocasadocodigo.entities.cupom.Cupom;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Contagem de carga intrínseca da classe: 6
 */

public class CupomValidador {

    //1
    public static boolean cupomValido(CompraNovoRequest compra, EntityManager manager) {

        //1
        if (compra.getPedido().getCodigoCupom() == null){ //Não há cupom para validar
            return true;
        }

        //1
        List<Cupom> listaCupom =  manager
                .createQuery("SELECT c FROM Cupom c WHERE c.codigo = :codigo", Cupom.class)
                .setParameter("codigo", compra.getPedido().getCodigoCupom())
                .setMaxResults(1)
                .getResultList();
        //1
        if(listaCupom.isEmpty()) { // Código não foi localizado
            return false;
        }

        Cupom cupom = listaCupom.get(0);

        //1
        if(cupom.vencido()) { //Código vencido
            return false;
        }

        //1
        List<Compra> listaCompra = manager
                .createQuery("SELECT c FROM Compra c WHERE cupom = :cupom_id", Compra.class)
                .setParameter("cupom_id", cupom)
                .getResultList();

        return listaCompra.isEmpty(); //Código já utilizado ou não
    }
}
