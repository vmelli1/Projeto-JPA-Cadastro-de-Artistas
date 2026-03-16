package com.alura.projetojpa.service.integracao.conversor;

import org.springframework.stereotype.Service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ConversorDadosService implements ConversorDadosServicePort {
    private ObjectMapper mapper = new ObjectMapper();



    @Override
    public <T> T converter(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
