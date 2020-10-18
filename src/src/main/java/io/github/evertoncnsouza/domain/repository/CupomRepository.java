package io.github.evertoncnsouza.domain.repository;

import io.github.evertoncnsouza.domain.entity.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, Long> {
//Esté Repository recebe dois tipos parametrizados, a Classe e o tipo do identifcador da classe;
        Optional<Cupom>findByCodigo(String codigo);
    //Método para trabalhar na classe CupomValidoValidator

}
