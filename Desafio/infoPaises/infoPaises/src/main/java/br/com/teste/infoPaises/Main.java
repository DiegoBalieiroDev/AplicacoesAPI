package br.com.teste.infoPaises;

import br.com.teste.infoPaises.model.Data;
import br.com.teste.infoPaises.service.ConsumeAPI;
import br.com.teste.infoPaises.service.ConvertData;

import java.util.Scanner;

public class Main {
    private Scanner scan = new Scanner(System.in);
    private ConsumeAPI consumeAPI = new ConsumeAPI();
    private ConvertData converter = new ConvertData();
    private String menu = """
            \n\n*** TYPE A COUNTRY TO KNOW ABOUT (EN) ***
            """;

    private String message = ("""
                \n*** OPTIONS ***
                1 - SEARCH A COUNTRY
                2 - QUIT
                """);

    private final String ADDRESS = "https://restcountries.com/v3.1/name/";
    private final String AFTERADRESS = "?fullText=true";


    public void countryInfo() {
        int options;

        do {
            System.out.println(message);
            while (!scan.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scan.next();
            }
            options = scan.nextInt();
            scan.nextLine();

            switch (options) {
                case 1 -> {
                    System.out.println(menu);
                    String country = scan.nextLine().toLowerCase().trim().replace(" ", "%20");
                    var json = consumeAPI.getData(ADDRESS + country + AFTERADRESS);
                    //System.out.println(json);
                    try {
                        var data = converter.getListClass(json, Data.class);
                        System.out.println(data);
                    } catch (RuntimeException e) {
                        System.out.println("Country not found! Please try another name.");
                    }

                }
                case 2 -> System.out.println("Shutting down...");
                default -> System.out.println("This option doesn't exist. Try again");
            }
        } while (options != 2);

    }
}

