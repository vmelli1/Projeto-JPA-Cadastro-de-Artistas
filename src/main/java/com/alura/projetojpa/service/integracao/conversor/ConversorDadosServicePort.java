package com.alura.projetojpa.service.integracao.conversor;

public interface ConversorDadosServicePort {
    <T> T converter(String json, Class<T> classe);
}
