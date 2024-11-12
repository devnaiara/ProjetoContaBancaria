Banco do Brasil com Z.
Este projeto simula um sistema bancário simples, com funcionalidades para criar, listar, atualizar, buscar, apagar contas e realizar operações como saque, depósito e transferência entre contas. Ele é desenvolvido em Java e segue o modelo de arquitetura MVC (Model-View-Controller), com foco na manipulação de contas bancárias.

Funcionalidades
O sistema possui as seguintes funcionalidades:

Criar Conta: O usuário pode criar uma conta corrente ou conta poupança, com os dados do titular, agência, saldo inicial, limite de crédito (para conta corrente) e aniversário da conta (para conta poupança).
Listar todas as contas: Exibe todas as contas cadastradas no sistema.
Buscar conta por número: Permite buscar os dados de uma conta através do número da conta.
Atualizar dados da conta: Permite atualizar os dados de uma conta existente.
Apagar conta: Exclui uma conta existente do sistema.
Sacar: Permite que o usuário realize um saque em uma conta.
Depositar: Permite que o usuário realize um depósito em uma conta.
Transferir valores entre contas: Permite transferir valores de uma conta para outra.
Arquitetura do Sistema
Model
O sistema possui duas classes principais para representar os tipos de contas bancárias:

ContaCorrente: Representa uma conta corrente, que possui um limite de crédito.
ContaPoupanca: Representa uma conta poupança, com uma data de aniversário.
Essas classes implementam a classe base Conta, que contém informações comuns a todas as contas, como número da conta, agência, titular e saldo.

Controller
A classe ContaController é responsável por gerenciar as operações realizadas no sistema, como a criação, atualização, exclusão de contas, além das operações bancárias (saque, depósito, transferência).

View
A classe Menu gerencia a interface do usuário, exibindo um menu com as opções disponíveis e interagindo com o usuário para receber entradas e mostrar as respostas.

Como Usar
Requisitos
Java 17 ou superior
IDE como IntelliJ IDEA, Eclipse ou NetBeans para facilitar o desenvolvimento
