-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 25/11/2024 às 16:34
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
-- Banco de dados: `banco_malvader`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `id_usuario`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `conta`
--

CREATE TABLE `conta` (
  `id_conta` int(11) NOT NULL,
  `numero_conta` varchar(20) NOT NULL,
  `agencia` varchar(10) DEFAULT NULL,
  `saldo` decimal(15,2) NOT NULL,
  `tipo_conta` enum('poupanca','corrente') NOT NULL,
  `id_cliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `conta`
--

INSERT INTO `conta` (`id_conta`, `numero_conta`, `agencia`, `saldo`, `tipo_conta`, `id_cliente`) VALUES
(1, '1001-1', '001', 1500.00, 'corrente', 1),
(2, '2002-2', '002', 3200.50, 'poupanca', 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `conta_corrente`
--

CREATE TABLE `conta_corrente` (
  `id_conta_corrente` int(11) NOT NULL,
  `taxa_rendimento` double(5,2) NOT NULL,
  `limite_conta` varchar(10) NOT NULL,
  `data_vencimento` date NOT NULL,
  `id_conta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `conta_corrente`
--

INSERT INTO `conta_corrente` (`id_conta_corrente`, `taxa_rendimento`, `limite_conta`, `data_vencimento`, `id_conta`) VALUES
(1, 1.25, '5000', '2024-12-31', 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `conta_poupanca`
--

CREATE TABLE `conta_poupanca` (
  `id_conta_poupanca` int(11) NOT NULL,
  `taxa_rendimento` decimal(5,2) DEFAULT NULL,
  `id_conta` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `conta_poupanca`
--

INSERT INTO `conta_poupanca` (`id_conta_poupanca`, `taxa_rendimento`, `id_conta`) VALUES
(1, 0.65, 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `endereco`
--

CREATE TABLE `endereco` (
  `id_endereco` int(11) NOT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `local` varchar(100) DEFAULT NULL,
  `numero_casa` int(11) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `endereco`
--

INSERT INTO `endereco` (`id_endereco`, `cep`, `local`, `numero_casa`, `bairro`, `cidade`, `estado`, `id_usuario`) VALUES
(1, '70000000', 'Rua A', 100, 'Asa Norte', 'Brasília', 'DF', 1),
(2, '71000000', 'Rua B', 200, 'Asa Sul', 'Brasília', 'DF', 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `id_funcionario` int(11) NOT NULL,
  `codigo_funcionario` varchar(50) NOT NULL,
  `cargo` varchar(50) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `funcionario`
--

INSERT INTO `funcionario` (`id_funcionario`, `codigo_funcionario`, `cargo`, `id_usuario`) VALUES
(1, 'F001', 'Gerente', 3);

-- --------------------------------------------------------

--
-- Estrutura para tabela `relatorio`
--

CREATE TABLE `relatorio` (
  `id_relatorio` int(11) NOT NULL,
  `tipo_relatorio` varchar(50) DEFAULT NULL,
  `data_geracao` timestamp NULL DEFAULT current_timestamp(),
  `conteudo` text DEFAULT NULL,
  `id_funcionario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `relatorio`
--

INSERT INTO `relatorio` (`id_relatorio`, `tipo_relatorio`, `data_geracao`, `conteudo`, `id_funcionario`) VALUES
(1, 'Financeiro Mensal', '2024-11-25 15:34:10', 'Relatório financeiro de novembro.', 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `transacao`
--

CREATE TABLE `transacao` (
  `id_transacao` int(11) NOT NULL,
  `tipo_transacao` enum('deposito','saque','transferencia') NOT NULL,
  `valor` decimal(15,2) NOT NULL,
  `data_hora` timestamp NULL DEFAULT current_timestamp(),
  `id_conta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `transacao`
--

INSERT INTO `transacao` (`id_transacao`, `tipo_transacao`, `valor`, `data_hora`, `id_conta`) VALUES
(1, 'deposito', 1000.00, '2024-11-25 15:34:10', 1),
(2, 'saque', 200.00, '2024-11-25 15:34:10', 1),
(3, 'deposito', 500.00, '2024-11-25 15:34:10', 2),
(4, 'saque', 100.00, '2024-11-25 15:34:10', 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `email` varchar(60) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `data_nascimento` date NOT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `tipo_usuario` enum('funcionario','cliente') NOT NULL,
  `senha` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nome`, `email`, `cpf`, `data_nascimento`, `telefone`, `tipo_usuario`, `senha`) VALUES
(1, 'Carlos Silva', 'carlos@gmail.com', '12345678901', '1990-05-14', '61998765432', 'cliente', 'senha123'),
(2, 'Mariana Lima', 'mariana@gmail.com', '98765432101', '1985-09-20', '61991234567', 'cliente', 'senha456'),
(3, 'Ana Souza', 'ana@gmail.com', '19283746501', '1995-03-10', '61993456789', 'funcionario', 'senha789');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Índices de tabela `conta`
--
ALTER TABLE `conta`
  ADD PRIMARY KEY (`id_conta`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Índices de tabela `conta_corrente`
--
ALTER TABLE `conta_corrente`
  ADD PRIMARY KEY (`id_conta_corrente`),
  ADD KEY `fk_id_conta` (`id_conta`);

--
-- Índices de tabela `conta_poupanca`
--
ALTER TABLE `conta_poupanca`
  ADD PRIMARY KEY (`id_conta_poupanca`),
  ADD KEY `id_conta` (`id_conta`);

--
-- Índices de tabela `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`id_endereco`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Índices de tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id_funcionario`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Índices de tabela `relatorio`
--
ALTER TABLE `relatorio`
  ADD PRIMARY KEY (`id_relatorio`),
  ADD KEY `id_funcionario` (`id_funcionario`);

--
-- Índices de tabela `transacao`
--
ALTER TABLE `transacao`
  ADD PRIMARY KEY (`id_transacao`),
  ADD KEY `id_conta` (`id_conta`);

--
-- Índices de tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `cpf` (`cpf`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `conta`
--
ALTER TABLE `conta`
  MODIFY `id_conta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `conta_corrente`
--
ALTER TABLE `conta_corrente`
  MODIFY `id_conta_corrente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `conta_poupanca`
--
ALTER TABLE `conta_poupanca`
  MODIFY `id_conta_poupanca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `endereco`
--
ALTER TABLE `endereco`
  MODIFY `id_endereco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id_funcionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `relatorio`
--
ALTER TABLE `relatorio`
  MODIFY `id_relatorio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `transacao`
--
ALTER TABLE `transacao`
  MODIFY `id_transacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Restrições para tabelas `conta`
--
ALTER TABLE `conta`
  ADD CONSTRAINT `conta_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE CASCADE;

--
-- Restrições para tabelas `conta_corrente`
--
ALTER TABLE `conta_corrente`
  ADD CONSTRAINT `fk_id_conta` FOREIGN KEY (`id_conta`) REFERENCES `conta` (`id_conta`);

--
-- Restrições para tabelas `conta_poupanca`
--
ALTER TABLE `conta_poupanca`
  ADD CONSTRAINT `conta_poupanca_ibfk_1` FOREIGN KEY (`id_conta`) REFERENCES `conta` (`id_conta`);

--
-- Restrições para tabelas `endereco`
--
ALTER TABLE `endereco`
  ADD CONSTRAINT `endereco_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Restrições para tabelas `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Restrições para tabelas `relatorio`
--
ALTER TABLE `relatorio`
  ADD CONSTRAINT `relatorio_ibfk_1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`);

--
-- Restrições para tabelas `transacao`
--
ALTER TABLE `transacao`
  ADD CONSTRAINT `transacao_ibfk_1` FOREIGN KEY (`id_conta`) REFERENCES `conta` (`id_conta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
