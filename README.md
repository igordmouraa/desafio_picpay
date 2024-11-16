# Projeto Desafio PicPay

## Visão Geral

Este projeto é um exemplo de aplicação utilizando Jakarta EE, Spring Data JPA, Spring MVC e Lombok. A aplicação simula o funcionamento de uma carteira digital com funcionalidades de cadastro, consulta e operações financeiras básicas.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

- **Entity**: Contém as entidades JPA que mapeiam as tabelas do banco de dados. Exemplo: `Wallet`.
- **Repository**: Contém os repositórios Spring Data JPA que fornecem métodos para realizar operações com as entidades no banco de dados. Exemplo: `WalletRepository`.

## Tecnologias Utilizadas

- **Jakarta EE**: Utilizado para persistência e entidades JPA.
- **Spring Data JPA**: Fornece abstração para a camada de persistência.
- **Spring MVC**: Utilizado para a camada de controle.
- **Lombok**: Facilita a definição de entidades e reduz o boilerplate code.

## Classes Principais

### Entidade `Wallet`

A entidade `Wallet` representa a carteira digital de um usuário. Esta entidade possui os seguintes atributos:

- `id`: Identificador único da carteira.
- `fullName`: Nome completo do usuário.
- `cpfCnpj`: CPF ou CNPJ do usuário.
- `email`: Email do usuário.
- `password`: Senha do usuário.
- `balance`: Saldo disponível na carteira.
- `walletType`: Tipo da carteira, referenciando uma entidade de tipo de carteira.

Além dos atributos, a entidade `Wallet` possui métodos para verificar se transferências são permitidas, verificar o saldo disponível e realizar débitos e créditos.

### Repositório `WalletRepository`

O repositório `WalletRepository` fornece métodos para realizar operações CRUD com a entidade `Wallet`. Exemplo: encontrar uma carteira por CPF/CNPJ ou email.

## Configuração e Execução

### Pré-requisitos

- **Java SDK 23**
- **Maven**

### Passos para Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/igordmouraa/desafio_picpay
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd desafio_picpay
   ```
3. Construa o projeto usando Maven:
   ```bash
   mvn clean install
   ```
4. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

## Contribuição

Sinta-se à vontade para abrir issues e enviar pull requests. Para maiores detalhes, veja o arquivo [CONTRIBUTING.md](./CONTRIBUTING.md).

## Licença

Este projeto está licenciado sob os termos da licença MIT. Veja o arquivo [LICENSE](./LICENSE) para mais detalhes.