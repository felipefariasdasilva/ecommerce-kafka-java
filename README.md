# :sparkler: E-commerce com Kafka

Aplicação Java de um E-commerce, utilizando o Kafka como mensageria.

## Começando

As instruções a seguir irão lhe proporcionar uma cópia deste projeto e de como rodar em sua máquina local para propósito de desenvolvimento e testes. Veja na sessão de [deployment](#Deployment) para saber com mais detalhes de como dar deploy em sua aplicação.

### Pre-requisitos

Dependências necessárias para se instalar o software e como instalá-las.

1. É necessário que você tenha Java instalado na sua máquina. Para verificar, rode o seguinte comando:

```
java -version
```

2. É necessário ter o Apache Maven (ferramenta de automação e gerenciamento do projeto) instalado também. Para verificar, rode o seguinte comando:

```
mvn -v
```

3. É necessário ter o Docker para executar os containers:
```
docker -v
```


### Instalação

Para rodar a aplicação, execute os próximos passos:

1. Faça o clone do projeto
```
https://github.com/felipefariasdasilva/ecommerce-kafka-java.git
```

2. Entre na pasta

```
cd ecommerce-kafka-java
```

3. Execute a aplicação com Maven

```
mvn spring-boot:run
```

4. Suba os containers do zookeeper e kafka através do docker-compose.yml em segundo plano(flag -d)
```
docker-compose up -d
```

---
**NOTE**

O template do docker-compose pode ser encontrado [Confluentinc@GitHub](https://github.com/confluentinc/cp-docker-images)<br>

---

:heavy_exclamation_mark: Obs.1: O template do docker-compose pode ser encontrado [Confluentinc@GitHub](https://github.com/confluentinc/cp-docker-images)<br>
:heavy_exclamation_mark: Obs.2: Zookeeper está com uma porta diferente do padrão. Ao invés de ser 2181, neste docker-compose está 2182

5. Verifique se os containers subiram de forma correta
```
docker-compose ps
```

Finalize com um exemplo obtendo dados do sistema ou fazendo uma pequena demostração do funcionamento da aplicação


## Dicas

1. Informações do tópico
```
 docker-compose exec kafka kafka-consumer-groups --all-groups --describe --bootstrap-server kafka:9092
```

2. Alterar numero de partições do tópico
```
docker-compose exec kafka kafka-topics --alter --topic ECOMMERCE_NEW_ORDER --partitions 3 --zookeeper zookeeper:2182
```

## Executando os testes

Explique como rodar os testes automáticos do seu sistema caso haja algum


### Análise dos testes fim-a-fim

Explique o que esses testes testam e o porquê.

```
Dê um exemplo
```

### Estilo de criação dos testes

Explique o que esses testes testam e o porque.

```
Dê um exemplo
```

## Deployment

Adicione notas de como dar deploy do sistema em produção.

## Desenvolvido com
* [Spring Boot](https://spring.io/projects/spring-boot) - O framework web utilizado
* [Maven](https://maven.apache.org/) - Gerenciador de dependências
* [Docker](https://www.docker.com/) - Criado de Containers
* [Kafka](https://kafka.apache.org//) - Plataforma distribuída de stream

## Contribuições

Criar um arquivo chamado CONTRIBUTING.md e colocar suas regras para contribuição nesse repositório.

Por favor leia [CONTRIBUTING.md]() para mais detalhes a respeito do nosso código de contuda e o processo de submissão de pull-requests para nós.

## Versionamento

Nós usamos [GitHub](https://github.com/) para versionamento. Para visualizar as versões disponíveis veja [tags nesse repositórios](https://github.com/your/project/tags). 

## Autores

* **Felipe Farias** - *Trabalho inicial* - [@felipefariasdasilva](https://github.com/felipefariasdasilva)

Veja também a lista completa de [contribuidores](https://github.com/your/project/contributors) que contribuiram para o desenvolvimento deste projeto.

## Licença

Esse projeto é licenciado pela MIT License - veja também [LICENSE.md](LICENSE.md) para mais detalhes

## Agradecimentos

* Inspiração
* etc
