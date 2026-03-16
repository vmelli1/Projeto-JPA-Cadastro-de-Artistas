package com.alura.projetojpa.dto;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ArtistaResponse(
    List<InfoArtistaDto> artists
    
) {

}
