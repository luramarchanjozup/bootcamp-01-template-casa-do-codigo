package com.guiferrini.CasaCodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guiferrini.CasaCodigo.model.Cupon;

@Repository
public interface CuponRepository extends JpaRepository<Cupon, String> {
	public Cupon getById(String id);
}
