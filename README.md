# Banco Malvader
Aplicação de banco em **Java**, com interface gráfica **Swing** e salvamento em um banco de dados **MySQL** e aplicando os conceitos de **Programação Orientada a Objetos (POO)** e **Estrutura MVC**.

### Tecnologias Utilizadas
* **Java** (Linguagem do sistema);
* **Swing** (Interface gráfica);
* **MySQL** (Banco de Dados).

## Diagramas de Arquitetura
### Diagrama de Classe
![Diagrama de Classe](/diagramas/DiagramaClasse.png "Diagrama de Classe")
### Diagrama de Sequência
![Diagrama de Sequência](/diagramas/DiagramaSequencia.png "Diagrama de Sequeência")

## Estrutura do Código
### controllers
Pasta responsável pelos controladores da aplicação, que gerenciam a lógica entre as views e os dados.
* **BancoController:** Faz ...
* **UsuarioController:** Faz ...
### dao
Pasta que contém as classes de acesso a dados (Data Access Object), responsáveis por interagir diretamente com o banco de dados.
* **ClienteDAO:** Faz ...
* **ConnectionFactory:** Faz ...
* **FuncionarioDAO:** Faz ...
### models
Pasta que define as classes de modelo (entidades) utilizadas na aplicação.
* **Cliente:** Faz ...
* **Funcionario:** Faz ...
* **Conta:** Faz ...
* **Endereco:** Faz ...
### startpoint
Pasta que contém classes iniciais e utilitárias da aplicação.
* **BancoMalvader:** Faz ...
* **ConexaoBanco:** Faz ...
* **Relatorio:** Faz ...
* **Usuario:** Faz ...
### utils
Pasta que contém classes utilitárias usadas em várias partes do sistema.
* **DBUtils:** Faz ...
* **DataManager:** Faz ...
### views
Pasta que contém as interfaces de usuário (UI) da aplicação.
* **TelaInicial:** Faz ...
* **TelaCliente:** Faz ...
* **TelaFuncionario:** Faz ...
* **Main:** Faz ...

## Estrutura do Banco
###	Tabela usuario
Armazena dados comuns para usuários do sistema, tanto funcionários quanto clientes.
*	**id_usuario (PK, INT, AUTO_INCREMENT):** Identificador único do usuário.
*	**nome (VARCHAR, 100):** Nome completo do usuário.
*	**cpf (VARCHAR, 11):** CPF do usuário.
*	**data_nascimento (DATE):** Data de nascimento.
*	**telefone (VARCHAR, 15):** Telefone de contato.
*	**tipo_usuario (ENUM: 'FUNCIONARIO', 'CLIENTE'):** Define se o usuário é funcionário ou cliente.
*	**senha (VARCHAR, 50):** Senha para acesso ao sistema.
### Tabela funcionario
Armazena dados específicos dos funcionários.
*	**id_funcionario (PK, INT, AUTO_INCREMENT):** Identificador único do funcionário.
*	**codigo_funcionario (VARCHAR, 20):** Código interno do funcionário.
*	**cargo (VARCHAR, 50):** Cargo do funcionário.
*	**id_usuario (FK, INT):** Relacionamento com a tabela usuario.
### Tabela cliente
Armazena dados específicos dos clientes.
*	**id_cliente (PK, INT, AUTO_INCREMENT):** Identificador único do cliente.
*	**id_usuario (FK, INT):** Relacionamento com a tabela usuario.
### Tabela endereco
Armazena os endereços de usuários, vinculando clientes e funcionários aos respectivos endereços.
*	**id_endereco (PK, INT, AUTO_INCREMENT):** Identificador único do endereço.
*	**cep (VARCHAR, 10):** Código postal.
*	**local (VARCHAR, 100):** Logradouro.
*	**numero_casa (INT):** Número da residência.
*	**bairro (VARCHAR, 50):** Bairro.
*	**cidade (VARCHAR, 50):** Cidade.
*	**estado (VARCHAR, 2):** Estado (sigla).
*	**id_usuario (FK, INT):** Relacionamento com a tabela usuario.
### Tabela conta
Tabela base para contas bancárias, tanto para poupança quanto para conta corrente.
*	**id_conta (PK, INT, AUTO_INCREMENT):** Identificador único da conta.
*	**numero_conta (VARCHAR, 20):** Número da conta.
*	**agencia (VARCHAR, 10):** Agência onde a conta foi criada.
*	**saldo (DECIMAL, 15,2):** Saldo atual da conta.
*	**tipo_conta (ENUM: 'POUPANCA', 'CORRENTE'):** Tipo da conta bancária.
*	**id_cliente (FK, INT):** Relacionamento com a tabela cliente.
### Tabela conta_corrente
Armazena dados específicos de contas correntes.
*	**id_conta_corrente (PK, INT, AUTO_INCREMENT):** Identificador da conta corrente.
*	**limite (DECIMAL, 15,2):** Limite de crédito da conta corrente.
*	**data_vencimento (DATE):** Data de vencimento do limite.
*	**id_conta (FK, INT):** Relacionamento com a tabela conta.
### Tabela conta_poupanca
Armazena dados específicos de contas poupança.
*	**id_conta_poupanca (PK, INT, AUTO_INCREMENT):** Identificador da conta poupança.
*	**taxa_rendimento (DECIMAL, 5,2):** Taxa de rendimento da poupança.
*	**id_conta (FK, INT):** Relacionamento com a tabela conta.
### Tabela transacao
Armazena todas as transações realizadas nas contas, como saques, depósitos e extratos.
*	**id_transacao (PK, INT, AUTO_INCREMENT):** Identificador único da transação.
*	**tipo_transacao (ENUM:** 'DEPOSITO', 'SAQUE', 'TRANSFERENCIA'): Tipo de transação realizada.
*	**valor (DECIMAL, 15,2):** Valor da transação.
*	**data_hora (TIMESTAMP):** Data e hora da transação.
*	**id_conta (FK, INT):** Relacionamento com a conta em que a transação foi realizada.
### Tabela relatorio
Armazena relatórios gerados pelos funcionários.
*	**id_relatorio (PK, INT, AUTO_INCREMENT):** Identificador único do relatório.
*	**tipo_relatorio (VARCHAR, 50):** Tipo de relatório gerado.
*	**data_geracao (TIMESTAMP):** Data e hora da geração do relatório.
*	**conteudo (TEXT):** Conteúdo do relatório.
*	**id_funcionario (FK, INT):** Relacionamento com a tabela funcionario.
### Relacionamentos
* **1:1** entre **usuario** e **funcionario / cliente** (um usuário pode ser um cliente ou um funcionário).
* **1:1** entre **usuario** e **endereco** (um usuário pode ter um endereço registrado).
* **1:N** entre **cliente** e **conta** (um cliente pode ter várias contas).
* **1:1** entre **conta** e **conta_corrente / conta_poupanca** (uma conta pode ser corrente ou poupança).
* **1:N** entre **conta** e **transacao** (uma conta pode ter várias transações).
* **1:N** entre **funcionario** e **relatorio** (um funcionário pode gerar vários relatórios).


## Interface Gráfica
#### Tela Inicial
A tela inicial apresenta o menu principal do sistema, com as seguintes opções:  
* **Funcionário:** Direciona o usuário para a tela de funcionalidades dos funcionários, solicitando login e senha.  
* **Cliente:** Direciona o usuário para a tela de funcionalidades dos clientes, solicitando login e senha.  
* **Encerrar o Programa:** Encerra o sistema e fecha a aplicação.
#### **Tela Funcionário**  
Após o login, a tela do funcionário exibe as opções disponíveis, organizadas em um menu claro e intuitivo:  
* **Abertura de Conta:**  
  Permite cadastrar uma nova conta bancária. O sistema solicita os dados do cliente e o tipo de conta (Poupança ou Corrente).  
* **Encerramento de Conta:**  
  Oferece a funcionalidade de encerrar uma conta existente. O sistema solicita o número da conta e a senha de administrador para confirmar a ação.  
* **Consulta de Dados:**  
  Permite buscar informações específicas sobre:  
    * Contas bancárias;  
    * Funcionários cadastrados;  
    * Clientes registrados no sistema.  
* **Alteração de Dados:**  
  Possibilita editar dados de:  
    * Contas bancárias;  
    * Funcionários;  
    * Clientes.  
* **Cadastro de Funcionários:**  
  Permite adicionar novos funcionários ao sistema. O cadastro só é realizado após a validação da senha de administrador.  
* **Geração de Relatórios:**  
  Gera relatórios gerais com informações do sistema. Os relatórios podem ser exportados para Excel e a funcionalidade exige autenticação com a senha de administrador.  
* **Sair:**  
  Encerra a sessão do funcionário e retorna à **Tela Inicial**.

#### **Tela Cliente**  
Após o login, a tela do cliente apresenta as funcionalidades disponíveis, organizadas em um menu simplificado:  
* **Exibir Saldo:**  
  Mostra o saldo da conta bancária após validação da senha.  
* **Depositar:**  
  Permite realizar um depósito. O usuário deve informar o valor a ser depositado e autenticar com a senha da conta.  
* **Sacar:**  
  Realiza saques na conta bancária. O sistema solicita o valor, verifica o saldo disponível e exige a senha para confirmação.  
* **Exibir Extrato:**  
  Exibe o extrato completo da conta com todas as movimentações. O extrato pode ser exportado para Excel.  
* **Consultar Limite:**  
  Informa o limite disponível da conta, mediante autenticação com a senha.  
* **Sair:**  
  Encerra a sessão do cliente e retorna à **Tela Inicial**.

## Fluxo de Execução
### Tela Inicial
O usuário escolhe entre:
  * **Funcionário:** Solicita login e senha para acesso à **Tela Funcionário**.
  * **Cliente:** Solicita login e senha para acesso à **Tela Cliente**.
  * **Encerrar o Programa:** Encerra o sistema.

### Tela Funcionário
*(Acessível apenas após login com credenciais válidas)*  
* **Abertura de Conta**  
  Solicita tipo de conta (Poupança ou Corrente), dados do cliente e confirma o cadastro.  
* **Encerramento de Conta**  
  Solicita número da conta e senha de administrador para confirmar encerramento.  
* **Consulta de Dados**  
  Oferece opções para consultar dados de:
    * Conta;
    * Funcionário;
    * Cliente.  
* **Alteração de Dados**  
  Permite editar dados de Conta, Funcionário ou Cliente.  
* **Cadastro de Funcionários**  
  Solicita dados do novo funcionário e senha de administrador para confirmar.  
* **Geração de Relatórios**  
  Gera relatórios gerais e exporta para Excel (requer senha de administrador).  
* **Sair**  
  Retorna para a **Tela Inicial**.

### Tela Cliente
*(Acessível apenas após login com credenciais válidas)*  
* **Exibir Saldo**  
  Solicita senha da conta e exibe saldo.  
* **Depositar**  
  Solicita valor a ser depositado e senha da conta.  
* **Sacar**  
  Solicita valor a ser sacado, senha da conta, e verifica saldo.  
* **Exibir Extrato**  
  Mostra o extrato da conta e possibilita exportar para Excel.  
* **Consultar Limite**  
  Solicita senha da conta e exibe o limite disponível.  
* **Sair**  
  Retorna para a **Tela Inicial**.

## Funcionalidades
* **Login de Funcionário:**  
  Acessar o sistema como funcionário, mediante autenticação.  
* **Login de Cliente:**  
  Acessar o sistema como cliente, mediante autenticação.  
* **Encerrar o Programa:**  
  Finalizar a execução do sistema.  
* **Abertura de Conta:**  
  Cadastrar novas contas bancárias (Poupança ou Corrente).  
* **Encerramento de Conta:**  
  Encerrar contas bancárias existentes (requer senha de administrador).  
* **Consulta de Dados:**  
  Consultar informações de contas bancárias, funcionários e clientes.  
* **Alteração de Dados:**  
  Editar dados de contas bancárias, funcionários e clientes.  
* **Cadastro de Funcionários:**  
  Registrar novos funcionários no sistema (requer senha de administrador).  
* **Geração de Relatórios:**  
  Criar relatórios gerais e exportar para Excel (requer senha de administrador).  
* **Exibir Saldo:**  
  Mostrar o saldo da conta bancária (requer autenticação com senha).  
* **Depositar:**  
  Realizar depósitos em contas bancárias, solicitando o valor e a senha.  
* **Sacar:**  
  Realizar saques, verificando o saldo disponível e solicitando autenticação com senha.  
* **Exibir Extrato:**  
  Apresentar o extrato da conta com detalhes das movimentações e opção de exportação para Excel.  
* **Consultar Limite:**  
  Mostrar o limite disponível da conta bancária (requer autenticação com senha).  
* **Sair de Sessão:**  
  Retornar à tela inicial ao encerrar a sessão de um funcionário ou cliente.

### Repositório para trabalho final da matéria de Laboratório de Banco de Dados da UCB.
