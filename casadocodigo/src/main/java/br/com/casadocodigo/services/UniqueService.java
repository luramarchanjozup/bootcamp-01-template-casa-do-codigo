package br.com.casadocodigo.services;

import br.com.casadocodigo.repositories.CategoryRepository;
import br.com.casadocodigo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniqueService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public boolean isUnique(String toBeValidated){

        if(userRepository.findByEmail(toBeValidated) == null &&
         categoryRepository.findByName(toBeValidated) == null

        ) { return true; }

        return false;

    }
}
