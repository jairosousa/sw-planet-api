# [Testes automatizados na prática com Spring Boot](https://www.udemy.com/course/testes-automatizados-na-pratica-com-spring-boot/?couponCode=ST16MT70224) [![Build Maven](https://github.com/jairosousa/sw-planet-api/actions/workflows/maven.yml/badge.svg)](https://github.com/jairosousa/sw-planet-api/actions/workflows/maven.yml)

![Java](https://img.shields.io/badge/Java-21-green?style=plastic&logo=java)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.2.2-green?style=plastic&logo=spring)
![Maven](https://img.shields.io/badge/Maven-3.9.2-green?style=plastic)
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

# Teste Unitários e Integração
Executar somente os teste unitários

```shell
./mvnw clean test
```

Executar todos os teste unitários + integração
| configurar o plugin no maven maven-surefire-plugin
```xml
            <!--Plugin teste-->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <configuration>
                    <skip>${surefire.skip}</skip>
                </configuration>
            </plugin>
```
Depois execute o comando
```shell
./mvnw clean verify
```

Executar somente os testes integrados
```shell
./mvnw clean verify -DskipSurefire=true
```

Executar somente de unidades
```shell
./mvnw clean verify -DskipITs=true
```

Executar só unitarios
```shell
./mvnw clean verify -DskipITs=true
```

```shell
./mvnw clean test
```

# Jacoco
```shell
./mvnw clean test jacoco:report
```

# Pitest
```shell
./mvnw test-compile org.pitest:pitest-maven:mutationCoverage
```
