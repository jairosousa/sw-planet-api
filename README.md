# [Testes automatizados na prática com Spring Boot](https://www.udemy.com/course/testes-automatizados-na-pratica-com-spring-boot/?couponCode=ST16MT70224) [![Build Maven](https://github.com/jairosousa/sw-planet-api/actions/workflows/maven.yml/badge.svg)](https://github.com/jairosousa/sw-planet-api/actions/workflows/maven.yml)
# Requisitos
* Experiência com desenvolvimento Spring Boot.
* Conhecimentos básicos sobre Serviços Web, Maven e Banco de dados relacional.

# Descrição
**Aprenda testes automatizados com Spring Boot na prática!**

Nesse curso, você vai aprender na prática a criar testes automatizados para seus projetos Spring Boot através da criação de uma API de planetas da franquia Star Wars!

**Está incluído no curso:**

1 - Introdução à testes automatizados

2 - Tipos de teste e a pirâmide

3 - Testes de Unidade, criando dublês de teste com o Mockito

4 - Testes de integração com o Spring Boot

5 - Testes subcutâneos com o Spring Boot

6 - Separação dos testes em fases

7 - Testes/análise de cobertura com o Jacoco

8 - Testes mutantes com o Pitest

9 - Exercícios passo-a-passo para se aprofundar

10 - E mais!

Algumas tecnologias que serão vistas são: Spring Boot Test, Junit 5, Mockito, AssertJ, Hamcrest, JsonPath, Jacoco, e Pitest.

Com testes automatizados nós obtemos as seguintes vantagens:

* Código mais estável, podemos mudar sem medo de quebrá-lo

* É fácil de verificar se software funciona, basta rodar os testes na sua máquina

* Temos confiança em mudar o software, pois podemos rodar os testes para checar se um bug acidental foi introduzido

E por causa de tudo isso, testes automatizados são aplamente usados pelas grandes empresas

E então, o que você está esperando? Se inscreva já no curso que fará você ser amado pelos seus colegas de trabalho por produzir um código com menos bug, mais legível, e portanto mais fácil de mudar ;)

# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.6/maven-plugin/reference/html/#build-image)

## Mysql Container
```shell
docker run --name some-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=starwars -e TZ=America/Sao_Paulo -d mysql:latest
```

```shell
docker exec -it some-mysql mysql -u root -p
```

```shell
mysql> show databases;
```

```shell
mysql> use nome banco;
```

```shell
mysql> show tables;
```

