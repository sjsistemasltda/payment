# Projeto de empréstimos

Este projeto configura um sistema de empréstimos, onde é possível fazer o cadastro de uma pessoa e também atribuí-a a um empréstimo.

## Conteúdo

- **Loan API**: Aplicação em Java 21 e SpringBoot.
- [**Arquitetura**](#arquitetura)

## Pré-requisitos

- Docker
- Docker Compose
- [IAC](https://github.com/sjsistemasltda/bank_iac)

## Como usar

1. **Clone o repositório**:
   ```sh
   git clone https://github.com/sjsistemasltda/loan
   cd loan

2. **Faça o build do docker**:
    ```sh
    docker-compose build;

3. **Inicie o container**:
    ```sh
    docker-compose up -d;

4. **Serviços em funcionamento**:
- Loan API: http://localhost:8082
- Actuator: http://localhost:8082/actuator/health

## cURLs de exemplo

**Pagar um empréstimo**:
```sh
curl --request POST \
  --url http://localhost:8082/v1/payments/{loanId}/pay \
  --header 'Content-Type: application/json' \
  --data '{}'
```

## Arquitetura
![](assets/payment_api.png)