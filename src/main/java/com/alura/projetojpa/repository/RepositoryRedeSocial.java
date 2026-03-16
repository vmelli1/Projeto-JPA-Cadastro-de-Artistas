package com.alura.projetojpa.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.alura.projetojpa.model.RedeSocial;

public interface RepositoryRedeSocial extends JpaRepository<RedeSocial, Long> 
{
    Optional<RedeSocial> findByPlataformaAndUrl(String plataforma, String url);

  
}
