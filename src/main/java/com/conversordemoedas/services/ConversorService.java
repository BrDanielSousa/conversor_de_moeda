package com.conversordemoedas.services;

import com.conversordemoedas.enums.CodeCoin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ConversorService {

    @Value("${api.conversor.key}")
    private String apiKey;

    private static final String CONVERSOR_PATH_ROOT = "https://api.apilayer.com/exchangerates_data/convert";

    public String converter(Double valor, CodeCoin moeda, CodeCoin moedaParaConverter) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(CONVERSOR_PATH_ROOT + "?to=" + moeda.name() + "&from=" + moedaParaConverter.name() + "&amount=" + valor))
                .header("apikey", apiKey)
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
