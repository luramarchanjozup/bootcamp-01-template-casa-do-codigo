package br.com.carlos.casadocodigo.domain.service;
import br.com.carlos.casadocodigo.domain.entity.Livro;

public interface CadastrarLivrosService {
    Livro criar(Livro livro);
    Livro builder(Livro livro);
}
