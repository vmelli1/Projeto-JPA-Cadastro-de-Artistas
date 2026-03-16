package com.alura.projetojpa.service.aplicacao;
import org.springframework.stereotype.Service;
import com.alura.projetojpa.model.Genero;

import com.alura.projetojpa.repository.RepositoryGenero;

@Service
public class GeneroService {
    private final RepositoryGenero repositoryGenero;

    public GeneroService(RepositoryGenero repositoryGenero) {
        this.repositoryGenero = repositoryGenero;
    }

    public void salvar(Genero genero) {
      if(repositoryGenero.findByNome(genero.getNome()).isPresent()){
        System.out.println("Já existe um gênero com o nome: " + genero.getNome());
        return;
      } else {
        repositoryGenero.save(genero);
        System.out.println("Gênero cadastrado com sucesso: " + genero.getNome());
      }
    }

}
