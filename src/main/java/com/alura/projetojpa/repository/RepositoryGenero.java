package com.alura.projetojpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alura.projetojpa.model.Genero;

public interface RepositoryGenero extends JpaRepository<Genero, Long> {
    Optional<Genero> findByNome(String nome);
}
