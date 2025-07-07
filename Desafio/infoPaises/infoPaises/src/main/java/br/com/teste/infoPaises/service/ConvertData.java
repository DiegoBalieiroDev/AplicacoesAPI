package br.com.teste.infoPaises.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class ConvertData implements IConvertData {

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getDataClass(String json, Class<T> c) {
        try {
            return mapper.readValue(json, c);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> getListClass(String json, Class<T> c) {

        CollectionType list = mapper.getTypeFactory()
                .constructCollectionType(List.class, c);
        try {
            return mapper.readValue(json, list);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
