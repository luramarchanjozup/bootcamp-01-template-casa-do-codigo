package br.com.casacodig.services;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.casacodig.dto.CupomDTO;
import br.com.casacodig.dto.CupomUpdateDTO;
import br.com.casacodig.model.Cupom;
import br.com.casacodig.repositories.CupomRepository;

@Service
public class CupomServices {

	@Autowired
	private CupomRepository cupomRepository;
	
	@PersistenceContext
	private EntityManager manager;
	
	public Cupom salvar(CupomDTO cupomdto) {
		Cupom cupom = cupomdto.toModel();
		manager.persist(cupom);
		return cupom;
	}
	
	
	public Cupom atualizar (CupomUpdateDTO cupomdto) {	
		Cupom cupomAntigo = cupomRepository.findByCodigo(cupomdto.getCodigo());
		Cupom cupomUpdate = new Cupom(cupomAntigo.getId(), cupomdto.getCodigo(), cupomdto.getPercdesconto(), cupomdto.getValidade());
		cupomRepository.save(cupomUpdate);
		return cupomUpdate;
	}
}
