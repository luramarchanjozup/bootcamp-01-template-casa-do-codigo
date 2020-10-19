package br.com.casacodig.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.casacodig.dto.EstadoDTO;
import br.com.casacodig.model.Estado;
import br.com.casacodig.repositories.EstadoRepository;


//Contagem de Pontos - TOTAL:3
//1 - EstadoRepository
//1 - EstadoDTO
//1 - Estado

@Service
public class EstadoServices {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@PersistenceContext
	private EntityManager manager;
	
	public Estado salvar(EstadoDTO estadodto) {
		Estado estado = estadodto.toModel(manager);
		return estadoRepository.save(estado);
	}
}
