package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.repositories;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRespository extends JpaRepository<Compra, Integer> {
}
