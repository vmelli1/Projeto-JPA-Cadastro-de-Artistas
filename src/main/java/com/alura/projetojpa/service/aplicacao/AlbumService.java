package com.alura.projetojpa.service.aplicacao;

import org.springframework.stereotype.Service;

import com.alura.projetojpa.model.Album;
import com.alura.projetojpa.repository.RepositoryAlbum;

@Service
public class AlbumService {
    private final RepositoryAlbum repositoryAlbum;

    public AlbumService(RepositoryAlbum repositoryAlbum) {
        this.repositoryAlbum = repositoryAlbum;
    }

    public void salvarCadastro(Album album){
        repositoryAlbum.save(album);
        System.out.println("Album cadastrado com sucesso: " + album.getNome());
    }


}
