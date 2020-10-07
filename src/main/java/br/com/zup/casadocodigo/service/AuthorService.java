package br.com.zup.casadocodigo.service;

import br.com.zup.casadocodigo.domain.Author;
import br.com.zup.casadocodigo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author save(Author author) {
        Author createdAuthor = authorRepository.save(author);
        return createdAuthor;
    }
}
