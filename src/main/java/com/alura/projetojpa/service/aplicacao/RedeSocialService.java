package com.alura.projetojpa.service.aplicacao;

import com.alura.projetojpa.model.RedeSocial;
import com.alura.projetojpa.repository.RepositoryRedeSocial;
import org.springframework.stereotype.Service;

@Service
public class RedeSocialService {
    private final RepositoryRedeSocial repositoryRedeSocial;

    public RedeSocialService(RepositoryRedeSocial repositoryRedeSocial) {
        this.repositoryRedeSocial = repositoryRedeSocial;
    }

    public void salvar(RedeSocial redeSocial) {
        if(repositoryRedeSocial.findByPlataformaAndUrl(redeSocial.getPlataforma(), redeSocial.getUrl()).isPresent()){
            System.out.println("Já existe uma rede social com a plataforma: " + redeSocial.getPlataforma() + " e URL: " + redeSocial.getUrl());
            return;
        } else {
            repositoryRedeSocial.save(redeSocial);
            System.out.println("Rede social cadastrada com sucesso: " + redeSocial.getPlataforma() + " - " + redeSocial.getUrl());
        }
    }
}

