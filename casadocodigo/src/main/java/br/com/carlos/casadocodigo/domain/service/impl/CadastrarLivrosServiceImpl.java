package br.com.carlos.casadocodigo.domain.service.impl;

import br.com.carlos.casadocodigo.domain.entity.Livro;
import br.com.carlos.casadocodigo.domain.repository.AutorRepository;
import br.com.carlos.casadocodigo.domain.repository.CategoriaRepository;
import br.com.carlos.casadocodigo.domain.repository.LivroRepository;
import br.com.carlos.casadocodigo.domain.service.CadastrarLivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarLivrosServiceImpl implements CadastrarLivrosService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository repository;

    @Override
    public Livro criar(Livro livro) {
        var responce = builder(livro);
        return repository.save(responce);
    }

    public Livro builder(Livro livro){
        var autor = autorRepository.getOne(livro.getAutor().getId());
        var categorias = categoriaRepository.getOne(livro.getCategoria().getId());
        livro.setAutor(autor);
        livro.setCategoria(categorias);
        return livro;
    }
}
