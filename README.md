# Projeto Desafio PicPay

## Visão Geral

Este projeto é um exemplo de aplicação utilizando Jakarta EE, Spring Data JPA, Spring MVC e Lombok. A aplicação simula o funcionamento de uma carteira digital com funcionalidades de cadastro, consulta de saldo, realização de transferências e visualização do histórico de transações.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

- **Entity**: Contém as entidades JPA que mapeiam as tabelas do banco de dados. Exemplo: `Wallet`, `Transfer`.
- **Repository**: Contém os repositórios Spring Data JPA que fornecem métodos para realizar operações com as entidades no banco de dados. Exemplo: `WalletRepository`, `TransferRepository`.
- **Service**: Contém a lógica de negócio da aplicação. Exemplo: `WalletService`, `TransferService`.
- **Controller**: Contém os controladores Spring MVC que expõem os endpoints da API. Exemplo: `WalletController`, `TransferController`.

## Tecnologias Utilizadas

- **Jakarta EE**: Utilizado para persistência e entidades JPA.
- **Spring Data JPA**: Fornece abstração para a camada de persistência.
- **Spring MVC**: Utilizado para a camada de controle.
- **Lombok**: Facilita a definição de entidades e reduz o boilerplate code.

## Funcionalidades

### Cadastro de Carteira

A API permite o cadastro de novas carteiras.

#### Endpoint

- `POST /wallets`: Cria uma nova carteira.

#### Exemplo de Solicitação

```http
POST /wallets
Content-Type: application/json

{
    "fullName": "John Doe",
    "cpfCnpj": "12345678901",
    "email": "johndoe@example.com",
    "password": "password",
    "walletType": "USER"
}
```

#### Exemplo de Resposta

```json
{
   "id": 1,
   "fullName": "John Doe",
   "cpfCnpj": "12345678901",
   "email": "johndoe@example.com",
   "password": "password",
   "balance": 0.00,
   "walletType": {
      "id": 1,
      "description": "user"
   }
}
```

### Consulta de Saldo

A API permite consultar o saldo de uma carteira.

#### Endpoint

- `GET /wallets/{id}/balance`: Retorna o saldo da carteira com o identificador fornecido.

#### Exemplo de Solicitação

```http
GET /wallets/1/balance
```

#### Exemplo de Resposta

```json
{
   "message": "O saldo do usuário John Doe é 1000.00"
}
```

### Transferências

A API permite realizar transferências entre carteiras.

#### Endpoint

- `POST /transfer`: Realiza uma transferência entre carteiras.

#### Exemplo de Solicitação

```http
POST /transfer
Content-Type: application/json

{
    "value": 100.00,
    "payer": 1,
    "payee": 2
}
```

#### Exemplo de Resposta

```json
{
   "id": "123e4567-e89b-12d3-a456-426614174000",
   "sender": {
      "id": 1,
      "fullName": "John Doe",
      "cpfCnpj": "12345678901",
      "email": "johndoe@example.com",
      "balance": 900.00,
      "walletType": {
         "id": 1,
         "description": "user"
      }
   },
   "receiver": {
      "id": 2,
      "fullName": "Jane Smith",
      "cpfCnpj": "98765432100",
      "email": "janesmith@example.com",
      "balance": 1100.00,
      "walletType": {
         "id": 1,
         "description": "user"
      }
   },
   "value": 100.00,
   "timestamp": "2023-10-07T15:00:00"
}
```

### Histórico de Transferências

A API permite visualizar o histórico de transferências de uma carteira específica, agora simplificando os dados de resposta para incluir apenas informações essenciais.

#### Endpoint

- `GET /wallets/{id}/transfers`: Retorna o histórico de transferências para a carteira com o identificador fornecido.

#### Exemplo de Solicitação

```http
GET /wallets/1/transfers
```

#### Exemplo de Resposta

```json
[
   {
      "id": "123e4567-e89b-12d3-a456-426614174000",
      "value": 100.00,
      "senderId": 1,
      "senderFullName": "John Doe",
      "receiverId": 2,
      "receiverFullName": "Jane Smith",
      "timestamp": "2023-10-07T15:00:00"
   }
]
```

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