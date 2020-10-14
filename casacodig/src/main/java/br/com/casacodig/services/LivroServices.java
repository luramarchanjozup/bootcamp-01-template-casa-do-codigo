package br.com.casacodig.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import br.com.casacodig.dto.LivroDTO;
import br.com.casacodig.model.Livro;

//Contagem de Pontos - TOTAL:3
//1 - LivroRepository
//1 - LivroDTO
//1 - Livro


@Service
public class LivroServices {

	@PersistenceContext
	private EntityManager manager;
	
	public Livro salvar(LivroDTO livrodto) {
		Livro livro = livrodto.toModel(manager);
		manager.persist(livro);
		return livro;
	}
	
	
	public List<Livro> listarLivros (){
		Query query = manager.createQuery("select l from Livro l");
		List<Livro> livros = query.getResultList();
		return livros;
	}
	
	public Livro listarId (Long id){
		Livro livro = manager.find(Livro.class,id);
		return livro;
	}
}
