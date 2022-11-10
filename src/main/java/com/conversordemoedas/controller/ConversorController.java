package com.conversordemoedas.controller;

import com.conversordemoedas.enums.CodeCoin;
import com.conversordemoedas.service.ConversorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path = "/conversor")
public class ConversorController {

    @Autowired
    private ConversorService conversorService;

    @GetMapping(path = "/{valor}/{moeda}/{moedaParaConverter}")
    public String getConverter(@PathVariable("valor") Double valor,
                               @PathVariable("moeda") CodeCoin moeda,
                               @PathVariable("moedaParaConverter") CodeCoin moedaParaConverter) throws IOException, InterruptedException {

        return conversorService.converter(valor, moeda, moedaParaConverter);
    }
}
