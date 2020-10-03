package com.itau.cdc.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itau.cdc.model.Pais;

public interface PaisJpsRepository extends JpaRepository<Pais, Long> {

}
