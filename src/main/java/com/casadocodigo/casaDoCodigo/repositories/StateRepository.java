package com.casadocodigo.casaDoCodigo.repositories;

import java.util.Optional;

import com.casadocodigo.casaDoCodigo.model.State;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
    Optional<State> findByName(String name);
}
