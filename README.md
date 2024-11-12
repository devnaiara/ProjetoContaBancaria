# Banco do Brasil com Z

Bem-vindo ao **Banco do Brasil com Z**, uma aplicação simples que simula um sistema bancário em Java. Aqui, você pode criar contas, fazer transferências, saques, depósitos e muito mais. Vamos brincar de banco? 😎

## Funcionalidades

A aplicação oferece algumas funcionalidades bem legais para você interagir com as contas bancárias:

1. **Criar Conta**: Crie contas correntes ou poupanças para o pessoal.
2. **Listar todas as Contas**: Veja todas as contas cadastradas no banco (aquelas que você tem controle!).
3. **Buscar Conta por Número**: Encontre aquela conta específica. Tudo por número.
4. **Atualizar Dados da Conta**: Mudou de agência? De titular? Atualize os dados da sua conta!
5. **Apagar Conta**: Adeus, conta! Se não precisar mais, a gente deleta pra você.
6. **Sacar**: Faça um saque quando precisar de grana (mas só se tiver saldo, né?).
7. **Depositar**: Envie uma graninha para a conta. (Sempre bom ter saldo!)
8. **Transferir Valores entre Contas**: O famoso pix! Troque grana entre contas como um profissional.

## Arquitetura do Sistema

A aplicação tem uma estrutura bem organizada, dividida em partes que cuidam de diferentes tarefas:

### Model

Aqui é onde as contas são representadas. Temos:

- **ContaCorrente**: Para quem adora um limite de crédito.
- **ContaPoupanca**: Para quem pensa no futuro, com aquele aniversário da conta todo especial.

Essas classes herdaram a classe `Conta`, que traz o básico: número da conta, agência, titular e saldo.

### Controller

A classe **ContaController** é a chefona, gerenciando todas as operações que rolam no sistema. É ela que vai fazer tudo acontecer, desde a criação de contas até os saques e transferências.

### View

E aqui entra a classe **Menu**. Ela é responsável por mostrar o menu e interagir com você, o usuário. Tudo isso para que você consiga escolher o que fazer com as suas contas e o seu dinheiro.

### Requisitos

Antes de rodar o projeto, você vai precisar de:

- **Java 17** ou superior.
- Uma **IDE** de sua escolha: IntelliJ IDEA, Eclipse, NetBeans, ou qualquer outra que você prefira.

