package com.alura.projetojpa.service.aplicacao;

import org.springframework.stereotype.Service;


import com.alura.projetojpa.model.Artista;
import com.alura.projetojpa.repository.RepositoryArtista;


@Service
public class ArtistaService {
    private final RepositoryArtista repositoryArtista;

    public ArtistaService(RepositoryArtista repositoryArtista) {
        this.repositoryArtista = repositoryArtista;
    }

    public void verificarDuplicidade(Artista artista) {
        // Verificar se já existe um artista com o mesmo nome
        var artistaExistente = repositoryArtista.findByNomeArtistico(artista.getNomeArtistico());

        if (artistaExistente.isPresent()) {
            System.out.println("Já existe um artista com o nome: " + artista.getNomeArtistico());
            return;
        } 
            repositoryArtista.save(artista);
            System.out.println("Artista cadastrado com sucesso: " + artista.getNomeArtistico());
        
    }

   public Artista buscarId(Long id){
    return  repositoryArtista.findById(id).orElseThrow(() -> new IllegalArgumentException("Artista não encontrado"));

   }

   public void listarArtistas() {
    var artistas = repositoryArtista.findAll();
    if (artistas.isEmpty()) {
        System.out.println("Nenhum artista cadastrado.");
    } else {
        System.out.println("Selecione um artista pelo seu ID:");
        artistas.forEach(artista -> System.out.println("ID: " + artista.getId() + ", Nome Artístico: " + artista.getNomeArtistico()));
    }
}

   public void listarTodosArtistasComTudo() {
    var artistas = repositoryArtista.buscarTodosArtistasComTudo();
    for (Artista artista : artistas) {
        System.out.println("Artista: " + artista.getNomeArtistico());

        System.out.println("Músicas:");
        artista.getMusicas().forEach(m -> System.out.println("  - " + m.getTitulo()));

        System.out.println("Álbuns:");
        artista.getAlbuns().forEach(a -> System.out.println("  - " + a.getNome()));

        System.out.println("Redes Sociais:");
        artista.getRedesSociais().forEach(r -> System.out.println("  - " + r.getPlataforma() + ": " + r.getUrl()));

        System.out.println("Gênero Principal:");
        artista.getGeneros().forEach(g -> System.out.println("  - " + g.getNome()));

        System.out.println("-------------------------------");
    }
   }
    
}
