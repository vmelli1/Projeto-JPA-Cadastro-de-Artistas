# Projeto JPA - Cadastro de Artistas (Projeto de Estudo)

Projeto de estudo desenvolvido com Java e Spring Boot para praticar:

- modelagem de entidades com JPA/Hibernate
- relacionamento entre tabelas
- organização em camadas (model, repository, service)
- integração com API externa
- execução via menu em linha de comando (CLI)

## Objetivo

Gerenciar artistas e suas informações relacionadas:

- musicas
- albuns
- genero
- redes sociais

Tambem existe integracao com API externa para buscar informacoes adicionais do artista, como biografia, e traduzir automaticamente o conteudo para portugues.

## Tecnologias

- Java 17
- Spring Boot 4.0.3
- Spring Data JPA
- PostgreSQL
- Maven
- Jackson

## Estrutura do projeto

```text
src/main/java/com/alura/projetojpa
  model/        -> entidades JPA
  repository/   -> interfaces de acesso a dados
  service/      -> regras de negocio e integracoes
  principal/    -> fluxo CLI (menu)
  dto/          -> objetos de transferencia de dados
```

## Como executar

### 1. Pre-requisitos

- Java 17 instalado
- PostgreSQL em execucao
- Maven (ou usar Maven Wrapper ja incluso)

### 2. Banco de dados

Crie um banco PostgreSQL com o nome:

```sql
CREATE DATABASE artista;
```

No arquivo `src/main/resources/application.properties` ajuste, se necessario:

- `spring.datasource.url`
- `spring.datasource.username`
- `spring.datasource.password`

### 3. Rodar o projeto

No terminal, dentro da pasta raiz do projeto:

```bash
./mvnw spring-boot:run
```

No Windows (PowerShell):

```powershell
.\mvnw.cmd spring-boot:run
```

### 4. Compilar

```bash
./mvnw -DskipTests compile
```

## Funcionalidades no menu

- Cadastrar musica
- Cadastrar artista
- Cadastrar album
- Cadastrar genero
- Cadastrar rede social
- Buscar informacoes de artista em API externa
- Listar artistas com dados relacionados

## Exemplos de Uso

### Menu Principal

O sistema inicia com um menu interativo com as principais opcoes:

```
Menu:
1. Cadastrar Música
2. Cadastrar Artista
3. Cadastrar Album
4. Cadastrar Gênero
5. Cadastrar Rede Social
6. Buscar Informações do Artista
7. Listar Artistas (com detalhes)
8. Sair
```

### Listar Artistas com Detalhes

Ao executar a opcao 7, o sistema exibe todos os artistas cadastrados com suas informacoes relacionadas:

```
Artista: Ariana Grande
Músicas:
  - thank u next
Albuns:
Redes Sociais:
Gênero Principal:

Artista: Lady Gaga
Músicas:
  - Bad Romance
Albuns:
  - The Fame (2008)
Redes Sociais:
  - Instagram: https://www.instagram.com/ladygaga/
Gênero Principal:
  - Dance-Pop
```

Demonstra o poder das queries com **LEFT JOIN FETCH** para trazer dados relacionados de forma otimizada.

### Buscar Informações do Artista

A opcao 6 integra-se com a API The AudioDB para buscar informacoes adicionais e traduzir a biografia automaticamente:

```
=== Buscar Informações do Artista ===

Digite o nome do artista:
Lady Gaga

Biografia Completa: Stefani Joanne Angelina Germanotta (nascida em 28 de marco de 1986), 
conhecida profissionalmente como Lady Gaga, é uma cantora, compositora e atriz americana. 
Ela é conhecida por suas mensagens de auto-capacitacao, moda e performances ao vivo. 
Gaga inicialmente se apresentou no teatro, aparecendo em pecas de ensino médio e estudo 
no CCAP21 através da Tisch School of the Arts da Universidade de Nova...
```

## Estado atual do projeto

Projeto em evolucao para aprendizado. Ja contempla:

- relacionamento entre entidades
- validacoes simples de duplicidade
- consultas com JPA Repository
- traducao de biografia com API externa

## Autor

Projeto desenvolvido para estudo e evolucao profissional em Java/Spring.
