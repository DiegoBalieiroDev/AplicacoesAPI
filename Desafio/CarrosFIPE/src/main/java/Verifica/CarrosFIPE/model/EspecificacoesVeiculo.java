package Verifica.CarrosFIPE.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EspecificacoesVeiculo (
        @JsonAlias ("Marca") String marca,
        @JsonAlias ("Modelo") String modelo,
        @JsonAlias ("Valor") String valor,
        @JsonAlias ("AnoModelo") Integer ano,
        @JsonAlias ("Combustivel") String tipoCombustivel,
        @JsonAlias ("CodigoFipe") String codigoFipe
){
}
