package com.conversordemoedas.services;

import com.conversordemoedas.enums.CodeCoin;
import com.conversordemoedas.models.HistoricoModel;
import com.conversordemoedas.repositories.HistoricoRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private HistoricoRepository historicoRepository;

    public String converter(Double valor, CodeCoin moeda, CodeCoin moedaParaConverter) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(CONVERSOR_PATH_ROOT + "?to=" + moedaParaConverter.name() + "&from=" + moeda.name() + "&amount=" + valor))
                .header("apikey", apiKey)
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject resposta = new JSONObject(response.body().toString());//Pegando as informacoes em tipo string e transformando em json

        var result = resposta.getDouble("result");//Pegando o valor do resultado da conversao

        var historicoModel = new HistoricoModel();

        historicoModel.setValorIncial(String.valueOf(valor));
        historicoModel.setMoeda(String.valueOf(moeda));
        historicoModel.setMoedaParaConverter(String.valueOf(moedaParaConverter));
        historicoModel.setValorConvertido(String.valueOf(result));

        historicoRepository.save(historicoModel);
        return response.body();
    }
}
