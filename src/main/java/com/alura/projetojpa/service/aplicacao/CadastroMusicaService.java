package com.alura.projetojpa.service.aplicacao;

import org.springframework.stereotype.Service;

import com.alura.projetojpa.model.CadastroMusica;
import com.alura.projetojpa.repository.RepositoryCadastroMusica;

@Service //
public class CadastroMusicaService {
    private final RepositoryCadastroMusica repositoryCadastroMusica;
    

    public CadastroMusicaService(RepositoryCadastroMusica repositoryCadastroMusica) {
        this.repositoryCadastroMusica = repositoryCadastroMusica;
    }

    public void verificarDuplicidadeEAdicionarMusica(CadastroMusica musica) {
        // Verificar se já existe uma música com o mesmo nome
        repositoryCadastroMusica.findByTituloAndArtista(
            musica.getTitulo(), 
            musica.getArtista()
        
        ).ifPresent(m -> {throw new RuntimeException ("Já existe uma música com o nome: " + musica.getTitulo());}); 

        repositoryCadastroMusica.save(musica);
        System.out.println("Música cadastrada com sucesso: " + musica.getTitulo());
        
    }


}
