package com.api.climate;

import com.api.climate.model.Dados;
import com.api.climate.service.ConsumoAPI;
import com.api.climate.service.ConverteDados;

import java.util.Scanner;

public class main {

    // https://api.weatherstack.com/current?access_key=21ec35a60b7f6d35280c156f61abf97a&query=Sao%20Paulo

    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private Scanner scan = new Scanner(System.in);

    private final String ENDERECO = "https://api.weatherstack.com/current?access_key=21ec35a60b7f6d35280c156f61abf97a&query=";
    private String menu = "\n\nDigite um local: ";

    public void weatherInfo() {
        System.out.print(menu);
        String local = scan.nextLine().replace(" ", "%20").trim();

        var json = consumo.obterDadosAPI(ENDERECO + local);
        //System.out.println(json);
        var dados = conversor.obterDadosClasse(json, Dados.class);
        System.out.println(dados);

    }
}
