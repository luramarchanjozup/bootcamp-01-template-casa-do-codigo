package com.example.apicasadocodigo.consultalivro;

import com.example.apicasadocodigo.novolivro.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}