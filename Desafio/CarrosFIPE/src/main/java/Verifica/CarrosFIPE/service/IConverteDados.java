package Verifica.CarrosFIPE.service;

import java.util.List;

public interface IConverteDados {

    // converte dados para uma classe generica
    <T> T obterDados(String json, Class<T> classe);

    <T>List<T> obterLista(String json, Class<T> classe);
}
