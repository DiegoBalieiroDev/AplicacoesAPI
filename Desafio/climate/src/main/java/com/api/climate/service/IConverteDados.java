package com.api.climate.service;

import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public interface IConverteDados {
    <T> T obterDadosClasse(String json, Class<T> classe);

    <T>List<T> obterListaClasse(String json, Class<T> classe);
}
