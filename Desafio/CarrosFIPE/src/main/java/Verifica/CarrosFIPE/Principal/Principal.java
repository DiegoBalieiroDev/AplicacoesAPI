package Verifica.CarrosFIPE.Principal;

import Verifica.CarrosFIPE.model.CodigoConsulta;
import Verifica.CarrosFIPE.model.DadosVeiculo;
import Verifica.CarrosFIPE.model.EspecificacoesVeiculo;
import Verifica.CarrosFIPE.service.ConsumoAPI;
import Verifica.CarrosFIPE.service.ConverteDados;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner scan = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private String menu = """
            *** OPÇÕES ***
            Carro
            Moto
            Caminhão
            
            Digite uma das opções para a consulta:
            """;


    private final String ENDERECO_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private final String APIMARCA = "/marcas";
    //private String endereco;

    public void exibeFIPE(){
        String endereco, veiculo;

        while (true) {

            System.out.println(menu);
            veiculo = scan.nextLine().trim().toLowerCase();

            if (veiculo.toLowerCase().contains("car")){
                endereco = ENDERECO_BASE + "carros/marcas";
                break;
            }else if (veiculo.toLowerCase().contains("mot")) {
                endereco = ENDERECO_BASE + "motos/marcas";
                break;
            } else if (veiculo.toLowerCase().contains("caminhoe")){
                endereco = ENDERECO_BASE + "caminhoes/marcas";
                break;
            } else {
                System.out.println("Opção inválida. Digite “carro”, “moto” ou “caminhão”.\n");
            }
        }
        var json = consumo.obterDados(endereco);
        //System.out.println(json);
        var dados = conversor.obterLista(json, DadosVeiculo.class);
        dados.stream()
                .sorted(Comparator.comparing( v-> Integer.parseInt(v.codigo())))
                .forEach(System.out::println);


        System.out.println("Informe o código da marca para consulta: ");
        var consultaCodigo = scan.nextLine();
        endereco = endereco + "/" + consultaCodigo + "/modelos";
        json = consumo.obterDados(endereco);
        //System.out.println(json);
        // usa obterDados por o consultaCódigo é uma lista já
        var modeloLista = conversor.obterDados(json, CodigoConsulta.class);
        System.out.println("\nModelos da marca: ");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(v-> Integer.parseInt(v.codigo())))
                .forEach(System.out::println);



        System.out.println("\nQual carro ou especificação te interessa? ");
        var veiculoInteresse = scan.nextLine();

        List<DadosVeiculo> veiculoBuscado = modeloLista.modelos().stream()
                .filter(v -> v.nome()
                        .toUpperCase()
                        .contains(veiculoInteresse.toUpperCase())
                        || String.valueOf(v.codigo())
                        .contains(veiculoInteresse))
                .sorted(Comparator.comparing(v-> Integer.parseInt(v.codigo())))
                .collect(Collectors.toList());

        System.out.println("\nModelos filtrados: ");
        veiculoBuscado.forEach(System.out::println);

        System.out.println("\nDigite o código do veículo que te interessa:");
        var codigoVeiculo = scan.nextLine();
        endereco = endereco + "/"+ codigoVeiculo + "/anos";
        json = consumo.obterDados(endereco);

        List<DadosVeiculo> anos = conversor.obterLista(json , DadosVeiculo.class);
        List<EspecificacoesVeiculo> especificacoesVeiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = endereco + "/" + anos.get(i).codigo().toString();
            json = consumo.obterDados(enderecoAnos);
            EspecificacoesVeiculo veiculoEspecificado = conversor.obterDados(json, EspecificacoesVeiculo.class);
            especificacoesVeiculos.add(veiculoEspecificado);
        }
        System.out.println("\nTodos veiculos filtrados: ");
        especificacoesVeiculos.forEach(System.out::println);





    }
}