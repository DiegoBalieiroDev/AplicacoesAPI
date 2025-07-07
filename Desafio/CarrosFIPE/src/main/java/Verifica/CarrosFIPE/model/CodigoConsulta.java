package Verifica.CarrosFIPE.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
// Só é necessário @JsonAlias se for inserir um nome diferente , exemplo @Json Alias ("nome") String descricao,
public record CodigoConsulta( List<DadosVeiculo> modelos) {
    @Override
    public List<DadosVeiculo> modelos() {
        return modelos;
    }
}
