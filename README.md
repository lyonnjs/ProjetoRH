---

# Sistema de Gestão de Funcionários e Vendas

## Descrição

Este projeto implementa um sistema de gestão de funcionários e vendas utilizando Java e MySQL. Ele permite o armazenamento de informações de funcionários e registros de vendas, além de consultas específicas, como encontrar o funcionário com o maior salário, o maior benefício ou a maior venda.

## Estrutura do Projeto

### Pacote: `org.example.database`

#### Classe `DateBase`
Gerencia a conexão com o banco de dados MySQL, usando URL, usuário e senha definidos para se conectar ao banco.

### Classe `FuncionarioDAO`
Responsável por operações relacionadas aos funcionários:

- **`save`**: Salva um novo funcionário no banco de dados com nome, cargo, salário, benefícios e data de contratação.
- **`buscaTodosFuncionarioPorSalarioeBeneficio`**: Retorna uma lista de funcionários com seus respectivos salários e benefícios.
- **`buscaTodosFuncionarioPorSalario`**: Retorna uma lista de salários de todos os funcionários.
- **`buscaFuncionarioPorBeneficio`**: Retorna uma lista de benefícios de todos os funcionários.
- **`buscaFuncionarioPorMaiorSalario`**: Retorna o funcionário com o maior salário.
- **`buscarfuncionarioPorMaiorBeneficio`**: Retorna o funcionário com o maior benefício.
- **`buscaFuncionarioPorNome`**: Busca um funcionário pelo nome, utilizando um filtro "like" para busca parcial.

### Classe `FuncionarioVendaDAO`
Gerencia as operações relacionadas às vendas de funcionários:

- **`save`**: Registra uma nova venda realizada por um funcionário no banco de dados, incluindo o nome do funcionário, o valor da venda e a data.
- **`buscarfuncionarioPorMaiorVenda`**: Retorna o funcionário que realizou a maior venda registrada.

## Requisitos

- **Java 8** ou superior
- **MySQL 8.0** ou superior

## Configuração

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/sistema-gestao-funcionarios-vendas.git
   ```

2. Configure seu banco de dados MySQL conforme necessário:
   - Nome do banco de dados: `db_rh`
   - Usuário: `root`
   - Senha: `12345`

3. Insira as informações de conexão no arquivo `DateBase.java`.

## Exemplo de Uso

```java
// Exemplo de criação de um funcionário e registro de uma venda
FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
funcionarioDAO.save("João Silva", Cargo.GERENTE, 5000.00, 500, LocalDateTime.now());

FuncionarioVendaDAO vendaDAO = new FuncionarioVendaDAO();
vendaDAO.save(new Funcionario("João Silva", 1), 1500.00, LocalDateTime.now());
```
