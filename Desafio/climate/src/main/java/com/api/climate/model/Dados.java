package com.api.climate.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Dados(
        Request request,
        Location location,
        Current current
) {
    @Override
    public String toString() {
        return  "Tipo: " + ( request().type() != null ? request().type() : "N/A") +
                "\nPaís: " + (location().country != null ? location().country() : "N/A") +
                "\nHora local: " + (location().localtime() != null ? location().localtime() : "N/A") +
                " - " + (location().timezone_id() != null ? location().timezone_id() : "N/A") +
                "\nTemperatura: " + (current().temperature() != 0.0 ? current().temperature() + " °C" : "N/A") +
                "\nHumidade: " + (current().humidity() != 0.0 ? current().humidity() + " %": "N/A");

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Request(
            String type
    ) { }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Location(
            String country,
            String timezone_id,
            String localtime
    ){}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Current(
            double temperature,
            double humidity
    ){}
}


