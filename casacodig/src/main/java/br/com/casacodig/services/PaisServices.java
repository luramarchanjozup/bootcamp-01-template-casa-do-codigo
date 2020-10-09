package br.com.casacodig.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.casacodig.dto.PaisDTO;
import br.com.casacodig.model.Pais;
import br.com.casacodig.repositories.PaisRepository;

@Service
public class PaisServices {

	@Autowired
	private PaisRepository paisRepository;
	
	public Pais salvar(PaisDTO paisdto) {
		System.out.println("-------------PAIS SERVICE------------------");
		System.out.println(paisdto.toString());
		Pais pais = paisdto.toModel();
		return paisRepository.save(pais);
	}
	
}
