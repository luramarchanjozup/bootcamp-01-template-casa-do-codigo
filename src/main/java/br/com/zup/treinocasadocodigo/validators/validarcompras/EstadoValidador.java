package br.com.zup.treinocasadocodigo.validators.validarcompras;

import br.com.zup.treinocasadocodigo.entities.compra.CompraRequest;
import br.com.zup.treinocasadocodigo.entities.estado.Estado;
import br.com.zup.treinocasadocodigo.entities.pais.Pais;

import javax.persistence.EntityManager;

/**
 * Contagem de carga intrínseca da classe: 4
 */

public class EstadoValidador{

    //1
    public static boolean estadoValido(CompraRequest compra, EntityManager manager) {
        //1
        if (compra.getIdEstado() == null) {
            return true;
        }

        //1
        Pais pais = manager.find(Pais.class, compra.getIdPais());
        //1
        Estado estado = manager.find(Estado.class, compra.getIdEstado());

        return estado.pertenceAPais(pais);

    }
}
