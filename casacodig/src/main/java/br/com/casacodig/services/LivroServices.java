package br.com.casacodig.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.casacodig.dto.AutorDTO;
import br.com.casacodig.dto.LivroDTO;
import br.com.casacodig.model.Autor;
import br.com.casacodig.model.Livro;
import br.com.casacodig.repositories.LivroRepository;

@Service
public class LivroServices {

	@Autowired
	private LivroRepository livroRepository;
	
	public Livro salvar(LivroDTO livrodto) {

		//Livro livro = livrodto.toModel();
		//return livroRepository.save(livro);
		return null;
	}
}
