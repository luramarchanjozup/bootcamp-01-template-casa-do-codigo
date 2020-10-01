package br.com.casacodig.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.casacodig.dto.CategoriaDTO;
import br.com.casacodig.model.Categoria;
import br.com.casacodig.repositories.CategoriaRepository;

//Contagem de Pontos - TOTAL:3
//1 - CategoriaRepository
//1 - CategoriaDTO
//1 - Categoria

@Service
public class CategoriaServices {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria salvar(CategoriaDTO categoriadto) {

		Categoria categoria = categoriadto.toModel();
		return categoriaRepository.save(categoria);
	}
}
