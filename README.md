# Sistema de Gerenciamento de Pedidos
Projeto de Avaliação do 3 Semestre na ETB

## Sobre o projeto

Este projeto representa um sistema de gerenciamento de pedidos de uma loja. O sistema foi desenvolvido com base em um Modelo Entidade-Relacionamento (MER) e em um Diagrama de Classes UML.

A aplicação permite representar clientes, pedidos, produtos, fornecedores e entregadores, organizando as informações necessárias para realizar e entregar uma compra.

## Funcionamento

O sistema tem como principal elemento o **Pedido**, que possui informações como código, data, status e valor total.

Um pedido está relacionado a um **Cliente**, que realiza a compra, e a um **Entregador**, responsável pela entrega.

Os pedidos também podem possuir diferentes tipos de produtos:

- Prato
- Bebida
- Sobremesa

## Produtos

Os produtos são representados pela classe abstrata **Produto**, que possui atributos comuns:

- Código
- Nome
- Preço

A classe Produto possui três especializações:

### Prato

Possui informações específicas como:

- Descrição
- Tipo

### Bebida

Possui:

- Tamanho
- Informação se é alcoólica

### Sobremesa

Possui:

- Sabor
- Peso

## Cliente

O sistema possui a classe **Cliente**, que representa as pessoas que realizam os pedidos.

O cliente possui informações como:

- CPF
- Data de cadastro

Além disso, herda informações da classe abstrata **Pessoa**, como nome, endereço, telefone e e-mail.

## Entregador

A classe **Entregador** representa a pessoa responsável por realizar as entregas.

Possui informações específicas como:

- Matrícula
- Veículo

Também herda os dados básicos da classe **Pessoa**.

## Fornecedor

A classe **Fornecedor** representa as empresas responsáveis pelo fornecimento dos produtos.

Possui:

- Nome
- CNPJ
- Número do contrato

Os produtos possuem relacionamento com um fornecedor.

## Pedido

A classe **Pedido** representa a compra realizada pelo cliente.

Possui os seguintes atributos:

- Código
- Data
- Status
- Total

O pedido possui relacionamentos com:

- Cliente
- Entregador
- Prato
- Bebida
- Sobremesa

## Estrutura do projeto

```text
Pessoa
├── Cliente
└── Entregador

Produto
├── Prato
├── Bebida
└── Sobremesa

Fornecedor
     ↓
  Produtos

Cliente
     ↓
   Pedido
     ↓
Entregador
