package com.alura.projetojpa.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) 
public record DadosRespostaResponse(@JsonAlias(value = "translatedText")String textoTraduzido) {
    
}
