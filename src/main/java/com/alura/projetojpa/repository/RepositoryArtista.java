package com.alura.projetojpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.alura.projetojpa.model.Artista;


import java.util.List;
import java.util.Optional;

public interface RepositoryArtista extends JpaRepository<Artista, Long> {
    boolean existsByNomeArtistico(String nomeArtistico);
    Optional<Artista> findByNomeArtistico(String nomeArtistico);
    Optional<Artista> findById(Long id);

    @Query("""
    SELECT DISTINCT a
    FROM Artista a
    LEFT JOIN FETCH a.musicas
    LEFT JOIN FETCH a.albuns
    LEFT JOIN FETCH a.redesSociais
    LEFT JOIN FETCH a.generos
    """)
    List<Artista> buscarTodosArtistasComTudo();

      
}
