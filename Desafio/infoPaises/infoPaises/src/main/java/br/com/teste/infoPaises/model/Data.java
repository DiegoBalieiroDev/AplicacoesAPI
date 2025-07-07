package br.com.teste.infoPaises.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Data(
        Name name,
        List<String> capital,
        Map<String, String> languages,
        Map<String, Currency>  currencies
) {
    @Override
    public String toString() {
        return "\nCountry name: " + (name != null ? name.common : "N/A") +

                "\nOfficial country name: " + (name != null ? name.official : "N/A") +

                "\nNative name: " + (name != null && name.nativeName() != null ?
                name.nativeName().values().stream()
                .findFirst()
                .map(NativeName::common)
                .orElse("N/A")
                : "N/A") +

                "\nNative official name: " + (name != null && name.official != null ?
                name.nativeName().values().stream()
                        .findFirst()
                        .map(NativeName::official)
                        .orElse("N/A")
                :"N/A") +

                "\nCapital: " + (capital != null && !capital.isEmpty() ? String.join(", ", capital) : "N/A") +


                "\nLanguages: " + (languages != null && !languages.isEmpty() ? String.join(", ", languages.values()) : "N/A" ) +

                "\nCurrencies: " + (currencies != null && !currencies().isEmpty() ?
                currencies().values().stream()
                        .findFirst()
                        .map(Currency::name)
                        .orElse("N/A")
                : "N/A") +

                " - Symbol: " + (currencies != null && !currencies().isEmpty() ?
                currencies().values().stream()
                        .findFirst()
                        .map(Currency::symbol)
                        .orElse("N/A")
                        : "N/A");


    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Name(
            String common,
            String official,
            Map<String, NativeName> nativeName
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record NativeName(
            String official,
            String common
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Currency(
            String name,
            String symbol
    ) {}
}
