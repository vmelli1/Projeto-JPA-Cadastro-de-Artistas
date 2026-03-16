package com.alura.projetojpa.service.integracao.traducao;

import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.alura.projetojpa.dto.DadosTraducaoResponse;
import com.alura.projetojpa.service.integracao.http.ConsumoApiService;

import java.net.URLEncoder;


public class ConsultaMyMemoryService {
    public static String obterTraducao(String text) {
        ObjectMapper mapper = new ObjectMapper();
        ConsumoApiService consumoApi = new ConsumoApiService();

        String texto = URLEncoder.encode(text, StandardCharsets.UTF_8);

        var langpair = URLEncoder.encode("en|pt-br", StandardCharsets.UTF_8);

        String url = "https://api.mymemory.translated.net/get?q=" + texto + "&langpair=" + langpair;

        String json = consumoApi.buscarInfo(url);

        DadosTraducaoResponse traducao;
        try {
            traducao = mapper.readValue(json, DadosTraducaoResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return traducao.dadosResposta().textoTraduzido();

    }

}
