package br.com.casacodig.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.Query;
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
	
	@PersistenceContext
	private EntityManager manager;
	
	public Livro salvar(LivroDTO livrodto) {

		Livro livro = livrodto.toModel(manager);
		//System.out.println("-------------LIVRO SERVICE------------------");
		//System.out.println(livro.toString());
		Livro resposta = livroRepository.save(livro);
		//System.out.println("-------------LIVRO RESPOSTA------------------");
		//System.out.println(resposta.toString());
		return resposta;
		//return livroRepository.save(livro);
	}
	
	
	public List<Livro> listarLivros (){
		System.out.println("-------------LIVRO SERVICE LISTAR------------------");
		Query query = manager.createQuery("select l from Livro l");
		List livros = query.getResultList();
		System.out.println(livros.toString());
		return livros;
	}
	
	public Livro listarId (Long id){
		Livro livro = manager.find(Livro.class,id);
		return livro;
	}
}
