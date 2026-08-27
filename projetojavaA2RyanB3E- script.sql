-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 08/12/2024 às 23:53
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `projetojavaa2wesley3e`
--
CREATE DATABASE IF NOT EXISTS `projetojavaa2ryan3e` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `projetojavaa2ryan3e`;

-- --------------------------------------------------------

--
-- Estrutura para tabela `bebida`
--

CREATE TABLE `bebida` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `preco` float(10,2) NOT NULL,
  `volume` int(11) NOT NULL,
  `alcoolica` varchar(45) NOT NULL,
  `Fornecedor_cnpj` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `bebida`
--

INSERT INTO `bebida` (`codigo`, `nome`, `preco`, `volume`, `alcoolica`, `Fornecedor_cnpj`) VALUES
(1, 'Heineken', 8.50, 1000, 'Não', '101010'),
(2, 'Pilsen', 3.50, 200, 'Sim', '011.222.333/54'),
(3, 'Coca Cola', 3.50, 300, 'Não', '011.222.333/54');

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
--

CREATE TABLE `cliente` (
  `cpf` varchar(20) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `idade` int(11) NOT NULL,
  `endereco` varchar(45) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `dataCadastro` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `cliente`
--

INSERT INTO `cliente` (`cpf`, `nome`, `idade`, `endereco`, `telefone`, `email`, `dataCadastro`) VALUES
('014.418.432-54', 'João Silva', 22, 'Rua da Sapucaí', '(21) 9 9181-4679', 'marcos055@gmail.com', '01/02/2024'),
('014.918.452-54', 'Ruan', 45, 'Bosque das Laranjeiras', '(11) 9 9177-4619', 'pedrosampa1425@gmail.com', '15/03/2023');

-- --------------------------------------------------------

--
-- Estrutura para tabela `entregador`
--

CREATE TABLE `entregador` (
  `matricula` varchar(20) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `endereco` varchar(45) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `veiculo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `entregador`
--

INSERT INTO `entregador` (`matricula`, `nome`, `endereco`, `telefone`, `email`, `veiculo`) VALUES
('161425', 'Pedro Sampaio', 'Bosque das Laranjeiras', '(11) 9 9177-4619', 'pedrosampa1425@gmail.com', 'Honda CG 160 Start'),
('302549', 'João Paulo', 'Bairro Flamengo-SP', '(11) 9 9137-4429', 'joaopauloCRF@gmail.com', 'Yamaha Factor');

-- --------------------------------------------------------

--
-- Estrutura para tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `cnpj` varchar(30) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `numeroContrato` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `fornecedor`
--

INSERT INTO `fornecedor` (`cnpj`, `nome`, `numeroContrato`) VALUES
('011.222.333/14', 'BFAlimentos', 101014),
('011.222.333/44', 'Nestlé', 202015),
('011.222.333/54', 'BrasalAlimentos', 303016),
('101010', 'Piracanjuba', 101014);

-- --------------------------------------------------------

--
-- Estrutura para tabela `pedido`
--

CREATE TABLE `pedido` (
  `codigo` int(11) NOT NULL,
  `data` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `total` float(10,2) NOT NULL,
  `Entregador_matricula` varchar(20) NOT NULL,
  `Cliente_cpf` varchar(20) NOT NULL,
  `Bebida_codigo` int(11) DEFAULT NULL,
  `Prato_codigo` int(11) DEFAULT NULL,
  `Sobremesa_codigo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `pedido`
--

INSERT INTO `pedido` (`codigo`, `data`, `status`, `total`, `Entregador_matricula`, `Cliente_cpf`, `Bebida_codigo`, `Prato_codigo`, `Sobremesa_codigo`) VALUES
(1, '08/12/2023', 'Preparando', 150.00, '302549', '014.418.432-54', 2, 4, 1),
(3, '05/12/2024', 'Entregue', 150.00, '302549', '014.918.452-54', 2, 4, 2),
(43, '28/11/2024', 'Entregue', 150.50, '161425', '014.418.432-54', 3, 2, NULL);

-- --------------------------------------------------------

--
-- Estrutura para tabela `prato`
--

CREATE TABLE `prato` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `preco` float(10,2) NOT NULL,
  `descricao` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `Fornecedor_cnpj` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `prato`
--

INSERT INTO `prato` (`codigo`, `nome`, `preco`, `descricao`, `tipo`, `Fornecedor_cnpj`) VALUES
(1, 'Strogonoff', 35.25, 'Strogonoff de Frango', 'Prato quentíssimo', '101010'),
(2, 'Feijoada', 55.25, 'Feijoada completa para familia de 5 pessoas', 'Prato quente', '011.222.333/54'),
(4, 'Filé de Frango a Parmeggiana', 35.25, 'Peça de Frango a parmeggiana', 'Prato quente', '011.222.333/54');

-- --------------------------------------------------------

--
-- Estrutura para tabela `sobremesa`
--

CREATE TABLE `sobremesa` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `preco` varchar(45) NOT NULL,
  `sabor` varchar(45) NOT NULL,
  `peso` float(10,2) NOT NULL,
  `Fornecedor_cnpj` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `sobremesa`
--

INSERT INTO `sobremesa` (`codigo`, `nome`, `preco`, `sabor`, `peso`, `Fornecedor_cnpj`) VALUES
(1, 'Pudim de Leite condesado', '15.0', 'Salgadin', 2.00, '101010'),
(2, 'Cento de coxinhas', '45.0', 'Salgadin', 2.50, '011.222.333/54');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `bebida`
--
ALTER TABLE `bebida`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_Bebida_Fornecedor1_idx` (`Fornecedor_cnpj`);

--
-- Índices de tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cpf`);

--
-- Índices de tabela `entregador`
--
ALTER TABLE `entregador`
  ADD PRIMARY KEY (`matricula`);

--
-- Índices de tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`cnpj`);

--
-- Índices de tabela `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_Pedido_Entregador_idx` (`Entregador_matricula`),
  ADD KEY `fk_Pedido_Cliente1_idx` (`Cliente_cpf`),
  ADD KEY `fk_Pedido_Bebida1_idx` (`Bebida_codigo`),
  ADD KEY `fk_Pedido_Prato1_idx` (`Prato_codigo`),
  ADD KEY `fk_Pedido_Sobremesa1_idx` (`Sobremesa_codigo`);

--
-- Índices de tabela `prato`
--
ALTER TABLE `prato`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_Prato_Fornecedor1_idx` (`Fornecedor_cnpj`);

--
-- Índices de tabela `sobremesa`
--
ALTER TABLE `sobremesa`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_Sobremesa_Fornecedor1_idx` (`Fornecedor_cnpj`);

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `bebida`
--
ALTER TABLE `bebida`
  ADD CONSTRAINT `fk_Bebida_Fornecedor1` FOREIGN KEY (`Fornecedor_cnpj`) REFERENCES `fornecedor` (`cnpj`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `fk_Pedido_Bebida1` FOREIGN KEY (`Bebida_codigo`) REFERENCES `bebida` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Pedido_Cliente1` FOREIGN KEY (`Cliente_cpf`) REFERENCES `cliente` (`cpf`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Pedido_Entregador` FOREIGN KEY (`Entregador_matricula`) REFERENCES `entregador` (`matricula`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Pedido_Prato1` FOREIGN KEY (`Prato_codigo`) REFERENCES `prato` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Pedido_Sobremesa1` FOREIGN KEY (`Sobremesa_codigo`) REFERENCES `sobremesa` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `prato`
--
ALTER TABLE `prato`
  ADD CONSTRAINT `fk_Prato_Fornecedor1` FOREIGN KEY (`Fornecedor_cnpj`) REFERENCES `fornecedor` (`cnpj`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `sobremesa`
--
ALTER TABLE `sobremesa`
  ADD CONSTRAINT `fk_Sobremesa_Fornecedor1` FOREIGN KEY (`Fornecedor_cnpj`) REFERENCES `fornecedor` (`cnpj`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
