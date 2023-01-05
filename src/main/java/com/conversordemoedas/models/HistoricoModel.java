package com.conversordemoedas.models;

import com.conversordemoedas.enums.CodeCoin;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_HISTORICO")
public class HistoricoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String valorIncial;
    @Column(nullable = false, length = 5)
    private String moeda;
    @Column(nullable = false, length = 5)
    private String moedaParaConverter;
    @Column(nullable = false)
    private String valorConvertido;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getValorIncial(Double valor) {
        return valorIncial;
    }

    public void setValorIncial(String valorIncial) {
        this.valorIncial = valorIncial;
    }

    public String getMoeda(CodeCoin moeda) {
        return this.moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public String getMoedaParaConverter(CodeCoin moedaParaConverter) {
        return this.moedaParaConverter;
    }

    public void setMoedaParaConverter(String moedaParaConverter) {
        this.moedaParaConverter = moedaParaConverter;
    }

    public String getValorConvertido(double result) {
        return valorConvertido;
    }

    public void setValorConvertido(String valorConvertido) {
        this.valorConvertido = valorConvertido;
    }
}
