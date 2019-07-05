# Microservices Files

Este projeto é um sistema de análise de dados.

## Sumário

  - [Introdução](#introdu%C3%A7%C3%A3o)
  - [Principais recursos utilizados](#principais-recursos-utilizados)
  - [Pré-requisitos](#pr%C3%A9-requisitos)
  - [Instruções](#instala%C3%A7%C3%A3o)
  - [Autora](#autora)
  - [License](#license)

## Introdução

Sistema capaz de importar arquivos simples, ler, analisar os dados e gerar relatórios.

## Principais recursos utilizados

* [Java JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Ferramenta para desenvolver aplicações. Versão 8 utilizada.

* [Gradle](https://gradle.org/) - Ferramenta de automação e gerenciamento de projetos.

* [JUnit](https://junit.org/junit5/) - Framework de testes para Java.

* [RabbitMQ](https://www.rabbitmq.com/) - Servidor de mensageria de código.


## Pré-requisitos

O que foi necessário para rodar o projeto: 

- Java na versão 8
- GIT instalado
- RabbitMQ instalado


## Instruções para rodar o microsserviço

Passos necessários para rodar o projeto: 

- Clonar no projeto: 
```
  git clone 
  https://github.com/barbbecker/microservice-files.git
```

- Entre na raiz do primeiro serviço pelo terminal e execute os comandos:

```
    gradle build
```

```
    ./gradlew run
```

- Entre na raiz do segundo serviço pelo terminal e execute os comandos:

```
    gradle build
```

```
    ./gradlew run
```

- O sistema somente aceita arquivos .dat

- O sistema vai criar uma pasta dentro do diretório padrão %HOMEPATH%/data/ com duas pastas

- Pasta IN -> você irá colocar seus arquivos .dat

- Pasta OUT -> será gerado um relatório com as informações organizadas dos arquivos .dat que você colocou na pasta IN.


- Exemplo de conteúdo no arquivo .dat

```
    001ç1234567891234çDiegoç50000 001ç3245678865434çRenatoç40000.99
```

## Autora

* **Bárbara Becker da Rosa** -  [GitHub](https://github.com/barbbecker)

<a href="https://github.com/barbbecker">
  <img 
  alt="Imagem da Autora Bárbara Becker" src="https://avatars1.githubusercontent.com/u/39573350?s=460&v=4" width="100">
</a>


## License

Este projeto possui Licença MIT - veja o arquivo [LICENSE.md](LICENSE.md) para saber mais detalhes.
