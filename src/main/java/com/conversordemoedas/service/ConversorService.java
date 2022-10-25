package com.conversordemoedas.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ConversorService {

    public String converter(Integer quantia, String moeda, String moedaParaConverter) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.apilayer.com/exchangerates_data/convert?to=" + moeda + "&from=" + moedaParaConverter + "&amount=" + quantia))
                .header("apikey", "GGPjDUrCYZM4wXUbdL5DohLixlWnR5Hj")
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
