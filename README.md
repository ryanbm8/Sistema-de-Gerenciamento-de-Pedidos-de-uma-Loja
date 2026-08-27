Sistema de Gerenciamento de Pedidos
Projeto de Avaliação do 3 Semestre na ETB

Sobre o projeto

Este projeto consiste em um sistema de gerenciamento de pedidos, desenvolvido para representar o processo de compra e entrega de produtos.

O sistema permite relacionar clientes, pedidos, produtos, fornecedores e entregadores, organizando as informações necessárias para registrar uma compra e sua entrega.

O projeto foi modelado utilizando um Modelo Entidade-Relacionamento (MER) e um Diagrama de Classes UML, representando tanto a estrutura do banco de dados quanto a estrutura orientada a objetos do sistema.

Funcionamento do sistema

O funcionamento principal começa com o Cliente, que realiza um Pedido.

Cada pedido possui:

Código;
Data;
Status;
Valor total.

O pedido também está relacionado ao cliente responsável pela compra e ao entregador responsável pela entrega.

O Entregador possui informações como matrícula, nome, endereço, telefone, e-mail e veículo.

Produtos

O sistema trabalha com três tipos de produtos:

Prato
Bebida
Sobremesa

No diagrama de classes, essas três classes herdam características da classe abstrata Produto.

A classe Produto possui:

Código;
Nome;
Preço;
Método exibirDetalhes().

Essa estrutura permite utilizar herança para representar diferentes tipos de produtos dentro do sistema.

Prato

A classe Prato possui características específicas:

Descrição;
Tipo.
Bebida

A classe Bebida possui:

Tamanho;
Informação sobre ser alcoólica.
Sobremesa

A classe Sobremesa possui:

Sabor;
Peso.
Cliente

O sistema possui uma classe abstrata Pessoa, que contém informações comuns às pessoas cadastradas.

Os atributos da classe Pessoa são:

Nome;
Endereço;
Telefone;
E-mail.

A classe Cliente herda essas características e possui também:

CPF;
Data de cadastro.
Entregador

O Entregador também herda características da classe Pessoa.

Além dos atributos comuns, possui:

Matrícula;
Veículo.

Dessa forma, o sistema consegue representar o entregador responsável por um determinado pedido.

Fornecedor

Os produtos possuem relacionamento com a classe Fornecedor.

O fornecedor possui:

Nome;
CNPJ;
Número do contrato.

No MER, Fornecedor também está relacionado às entidades de produtos, permitindo identificar o fornecedor de pratos, bebidas e sobremesas.

Pedido

O Pedido é a principal entidade de relacionamento do sistema.

Ele possui:

codigo
data
status
total

Além disso, está relacionado a:

Cliente;
Entregador;
Prato;
Bebida;
Sobremesa.

Isso permite representar quais informações estão envolvidas em uma compra e em seu processo de entrega.

Estrutura do projeto

A estrutura conceitual pode ser representada da seguinte maneira:

                 Pessoa
                /      \
               /        \
          Cliente      Entregador
              \          /
               \        /
                 Pedido
                /  |  \
               /   |   \
           Prato Bebida Sobremesa
              \    |      /
               \   |     /
                Fornecedor
Modelo de dados

O MER representa as principais tabelas do banco:

Cliente
    ↓
Pedido
    ├── Prato
    ├── Bebida
    └── Sobremesa

Entregador
    ↓
Pedido

Fornecedor
    ↓
Prato
Bebida
Sobremesa

No banco de dados, o Pedido possui referências para o cliente, entregador e produtos, enquanto os produtos possuem referência ao fornecedor.

Tecnologias e conceitos

O projeto utiliza conceitos de:

Java;
Programação Orientada a Objetos (POO);
UML;
Diagrama de Classes;
Modelo Entidade-Relacionamento (MER);
Classes abstratas;
Herança;
Associação entre classes;
Modelagem de banco de dados.
Objetivo

O objetivo do projeto é modelar um sistema de gerenciamento de pedidos, aplicando conceitos de orientação a objetos e modelagem de banco de dados.

A utilização de classes abstratas e herança permite organizar os elementos do sistema de maneira estruturada, enquanto o MER representa como essas informações podem ser armazenadas e relacionadas em um banco de dados.

Diagrama

O projeto possui dois modelos principais:

MER — representa as entidades, atributos e relacionamentos do banco de dados.
Diagrama de Classes — representa as classes, atributos, métodos, herança e relacionamentos da aplicação.
Resumo

Em resumo, o projeto representa uma loja que recebe pedidos de clientes, trabalha com diferentes tipos de produtos, possui fornecedores para esses produtos e utiliza entregadores para realizar as entregas. O diagrama de classes organiza esses elementos utilizando conceitos de POO, principalmente abstração e herança, enquanto o MER representa sua estrutura para um banco de dados.
