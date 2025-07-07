package Verifica.CarrosFIPE.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculo(
        @JsonAlias ("codigo") String codigo,
        @JsonAlias ("nome") String nome)
        {

            @Override
    public String toString() {
        return "Codigo: " + codigo +
                " - Marca: " + nome;
    }

            @Override
            public String codigo() {
                return codigo;
            }

            @Override
            public String nome() {
                return nome;
            }
        }


