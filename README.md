# 📌 Sobre o Projeto
Reúne três aplicações de console em Java com Spring Boot. Cada módulo consome uma API externa para exibir no terminal:

- Detalhes de países (InfoPaises)

- Condições climáticas (Clima)
  
- Dados de veículos pela tabela FIPE (CarrosFIPE)
  
<br>

## Ferramentas Utilizadas 💻

- Java 11+

- Spring Boot (Linha de comando)

- Jackson Databind

- Java HTTP Client

- Maven 

  <br>
# ✨ Funcionalidades

<br>

## 🌍 InfoPaises
- Menu interativo com opções de busca e saída.

- Pesquisa por nome completo do país 

- Consome APIREST (https://restcountries.com/?ref=public_apis&utm_medium=website) e imprime:

- Nome comum e oficial

- Nome nativo e oficial nativo

- Capital

- Idiomas falados

- Moeda e símbolo

- Tratamento de erros: mensagem clara se o país não for encontrado.

<br>

## ☁️ Clima
- Prompt simples para entrada de qualquer local (cidade ou país).

- Formatação automática do texto

- Consome WeatherStack (https://weatherstack.com) e imprime:

- País e fuso horário

- Hora local

- Temperatura em °C

- Umidade em %

- Falha controlada em caso de resposta inválida ou chave de API incorreta.

<br>

## 🚗 CarrosFIPE

- Consome FIPE API HTTP REST (https://deividfortuna.github.io/fipe/?ref=public_apis&utm_medium=website) e imprime:

- Escolha de tipo de veículo: carro, moto ou caminhão.

- Listagem de marcas FIPE, ordenada pelo código.

- Seleção de marca via código para buscar modelos.

- Filtro de modelos por nome ou código, com saída ordenada.

- Para o modelo escolhido, itera sobre anos disponíveis e:

- Busca especificações detalhadas (marca, modelo, ano, combustível, valor, código FIPE)

- Agrega e exibe todas as versões encontradas

- Loop de interação até a finalização manual pelo usuário.

<br>

# 📂 Estrutura do Repositório
├── info-paises  
│   ├── pom.xml  
│   └── src  
│       └── main  
│           ├── java  
│           │   └── br/com/teste/infoPaises  
│           │       ├── InfoPaisesApplication.java  
│           │       ├── Main.java  
│           │       ├── model/Data.java  
│           │       └── service  
│           │           ├── ConsumeAPI.java  
│           │           ├── ConvertData.java  
│           │           └── IConvertData.java  
│           └── resources  
│  
├── clima  
│   ├── pom.xml  
│   └── src  
│       └── main  
│           ├── java  
│           │   └── com/api/climate  
│           │       ├── ClimateApplication.java  
│           │       ├── main.java  
│           │       ├── model/Dados.java  
│           │       └── service  
│           │           ├── ConsumoAPI.java  
│           │           ├── ConverteDados.java  
│           │           └── IConverteDados.java  
│           └── resources  
│  
└── carros-fipe  
    ├── pom.xml  
    └── src  
        └── main  
            ├── java  
            │   └── Verifica/CarrosFIPE  
            │       ├── CarrosFipeApplication.java  
            │       ├── Principal/Principal.java  
            │       ├── model  
            │       │   ├── CodigoConsulta.java  
            │       │   ├── DadosVeiculo.java  
            │       │   └── EspecificacoesVeiculo.java  
            │       └── service  
            │           ├── ConsumoAPI.java  
            │           ├── ConverteDados.java  
            │           └── IConverteDados.java  
            └── resources  
