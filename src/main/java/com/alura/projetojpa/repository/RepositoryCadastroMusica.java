package com.alura.projetojpa.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.projetojpa.model.Artista;
import com.alura.projetojpa.model.CadastroMusica;
import java.util.Optional;

public interface RepositoryCadastroMusica extends JpaRepository<CadastroMusica, Long> {
    Optional<CadastroMusica> findByTituloAndArtista(String titulo, Artista artista);
}
