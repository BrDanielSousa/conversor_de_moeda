package com.conversordemoedas.controllers;

import com.conversordemoedas.enums.CodeCoin;
import com.conversordemoedas.services.ConversorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/conversor")
@Api(value = "API REST CONVERSOR")
@CrossOrigin(origins = "*")// Liberatodos os dominios e acessar a api
public class ConversorController {

    @Autowired
    private ConversorService conversorService;

    @GetMapping(path = "/{valor}/{moeda}/{moedaParaConverter}")
    @ApiOperation(value = "Retorna a conversao da valor da moeda ")
    public String getConverter(@PathVariable("valor") Double valor,
                               @PathVariable("moeda") CodeCoin moeda,
                               @PathVariable("moedaParaConverter") CodeCoin moedaParaConverter) throws IOException, InterruptedException {

        return conversorService.converter(valor, moeda, moedaParaConverter);
    }
}
