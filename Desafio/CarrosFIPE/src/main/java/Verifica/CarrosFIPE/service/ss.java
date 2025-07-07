//package Verifica.CarrosFIPE.service;
//
//public class ss {
//    public static void main(String[] args) {
//        while (true) {
//            System.out.println("\nQual carro ou especificação te interessa? ");
//            String veiculoInteresse = scan.nextLine();
//
//            List<DadosVeiculo> veiculoBuscado;
//            try {
//                veiculoBuscado = modeloLista.modelos().stream()
//                        .filter(v -> v.nome()
//                                .toUpperCase()
//                                .contains(veiculoInteresse.toUpperCase())
//                                || v.codigo().contains(veiculoInteresse))
//                        // usar comparingInt evita warnings de raw Comparator
//                        .sorted(Comparator.comparingInt(v -> Integer.parseInt(v.codigo())))
//                        .collect(Collectors.toList());
//            } catch (NumberFormatException ex) {
//                System.out.println("Erro ao processar códigos dos modelos. Tente novamente.");
//                continue;
//            }
//
//            if (veiculoBuscado.isEmpty()) {
//                System.out.println("Nenhum modelo encontrado para '" + veiculoInteresse + "'. Tente novamente.");
//                continue;
//            }
//
//            System.out.println("\nModelos filtrados: ");
//            veiculoBuscado.forEach(System.out::println);
//            break; // saiu com sucesso
//        }
//    }
//}
