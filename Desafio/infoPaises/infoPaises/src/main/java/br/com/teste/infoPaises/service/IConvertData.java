package br.com.teste.infoPaises.service;

public interface IConvertData {
    <T> T getDataClass(String json, Class<T> c);
}
