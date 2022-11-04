package com.conversordemoedas.controller;

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

    @GetMapping(path = "/{quantidade}/{moeda}/{moedaParaConverter}")
    public String getConverter(@PathVariable("quantidade") Double valor,
                               @PathVariable("moeda") String moeda,
                               @PathVariable("moedaParaConverter") String moedaParaConverter) throws IOException, InterruptedException {

        return conversorService.converter(valor, moeda, moedaParaConverter);
    }
}
