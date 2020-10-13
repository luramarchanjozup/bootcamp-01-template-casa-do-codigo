package io.github.evertoncnsouza.domain.repository;

import io.github.evertoncnsouza.domain.entity.Cupom;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CupomRepository
        extends org.springframework.data.repository.Repository <Cupom, Long> {
//Esté Repository recebe dois tipos parametrizados, a Classe e o tipo do identifcador da classe;
        public Cupom findByCodigo(String codigo);
    //Método para trabalhar na classe CupomValidoValidator

}
