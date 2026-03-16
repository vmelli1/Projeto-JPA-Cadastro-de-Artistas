package com.alura.projetojpa.dto;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InfoArtistaDto(
    @JsonAlias("strBiography") String biografia
) {

    @Override
    public String toString() {
        return "Biografia Completa: " + biografia;
    }

  
    
}
