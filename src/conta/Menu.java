package conta;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.IOException;

public class Menu {

    public static void main(String[] args) {

        ContaController contas = new ContaController();
        Scanner leia = new Scanner(System.in);

        int opcao, numero, agencia, tipo, aniversario;
        String titular;
        float saldo, limite;

        while (true) {
            System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
                    + "*****************************************************");
            System.out.println("                                                     ");
            System.out.println("                BANCO DO BRAZIL COM Z                ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("            1 - Criar Conta                          ");
            System.out.println("            2 - Listar todas as Contas               ");
            System.out.println("            3 - Buscar Conta por Numero              ");
            System.out.println("            4 - Atualizar Dados da Conta             ");
            System.out.println("            5 - Apagar Conta                         ");
            System.out.println("            6 - Sacar                                ");
            System.out.println("            7 - Depositar                            ");
            System.out.println("            8 - Transferir valores entre Contas      ");
            System.out.println("            9 - Sair                                 ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("Entre com a opção desejada:                          ");
            System.out.println("                                                     " + Cores.TEXT_RESET);

            try {
                opcao = leia.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nDigite valores inteiros!");
                leia.nextLine();
                opcao = 0;
            }

            if (opcao == 9) {
                System.out.println("\nBanco do Brazil com Z - O seu futuro começa aqui!");
                sobre();
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println("\n Criar Conta");
                    System.out.println("\n Digite o Número da Agência: ");
                    agencia = leia.nextInt();
                    System.out.println("\n Digite o Nome do Titular: ");
                    leia.skip("\\R?");
                    titular = leia.nextLine();

                    do {
                        System.out.println("\n Digite o Tipo da Conta (1-CC ou 2-CP): ");
                        tipo = leia.nextInt();
                    } while (tipo < 1 || tipo > 2);

                    System.out.println("\n Digite o Saldo da Conta: ");
                    saldo = leia.nextFloat();

                    switch (tipo) {
                        case 1 -> {
                            System.out.println("\n Digite o Limite de Crédito: ");
                            limite = leia.nextFloat();
                            contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
                        }
                        case 2 -> {
                            System.out.println("\n Digite o dia do aniversário da conta: ");
                            aniversario = leia.nextInt();
                            contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
                        }
                    }
                    keyPress();
                    break;

                case 2:
                    System.out.println("\n Listar todas as Contas");
                    contas.listarTodas();
                    keyPress();
                    break;

                case 3:
                    System.out.println("\n Consultar dados da Conta - por número");
                    System.out.println("\n Digite o número da conta: ");
                    numero = leia.nextInt();
                    contas.procurarPorNumero(numero);
                    keyPress();
                    break;

                case 4:
                    System.out.println("\n Atualizar dados da Conta");
                    System.out.println("\n Digite o número da conta: ");
                    numero = leia.nextInt();

                    var buscaConta = contas.buscarNaCollection(numero);

                    if (buscaConta != null) {
                        tipo = buscaConta.getTipo();
                        System.out.println("\n Digite o número da agência: ");
                        agencia = leia.nextInt();
                        System.out.println("\n Digite o nome do titular: ");
                        leia.skip("\\R?");
                        titular = leia.nextLine();

                        System.out.println("\n Digite o saldo da conta: ");
                        saldo = leia.nextFloat();

                        switch (tipo) {
                            case 1 -> {
                                System.out.println("\n Digite o Limite de Crédito (R$): ");
                                limite = leia.nextFloat();
                                contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
                            }
                            case 2 -> {
                                System.out.println("\n Digite o dia do Aniversário da Conta: ");
                                aniversario = leia.nextInt();
                                contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
                            }
                            default -> System.out.println("\n Tipo de conta inválido!");
                        }
                    } else {
                        System.out.println("\n A Conta não foi encontrada! ");
                    }
                    keyPress();
                    break;

                case 5:
                    System.out.println("\n Apagar Conta");
                    System.out.println("\n Digite o número da conta: ");
                    numero = leia.nextInt();
                    contas.deletar(numero);
                    keyPress();
                    break;

                case 6:
                    System.out.println("\n Sacar");
                    System.out.println("\n Digite o número da conta: ");
                    numero = leia.nextInt();
                    System.out.println("\n Digite o valor do saque: ");
                    float valorSaque = leia.nextFloat();
                    contas.sacar(numero, valorSaque);
                    keyPress();
                    break;

                case 7:
                    System.out.println("\n Depositar");
                    System.out.println("\n Digite o número da conta: ");
                    numero = leia.nextInt();
                    System.out.println("\n Digite o valor do depósito: ");
                    float valorDeposito = leia.nextFloat();
                    contas.depositar(numero, valorDeposito);
                    keyPress();
                    break;

                case 8:
                    System.out.println("\n Transferir");
                    System.out.println("\n Digite o número da conta de origem: ");
                    int numeroOrigem = leia.nextInt();
                    System.out.println("\n Digite o número da conta de destino: ");
                    int numeroDestino = leia.nextInt();
                    System.out.println("\n Digite o valor da transferência: ");
                    float valorTransferencia = leia.nextFloat();
                    contas.transferir(numeroOrigem, numeroDestino, valorTransferencia);
                    keyPress();
                    break;

                default:
                    System.out.println("\nOpção Inválida" + Cores.TEXT_RESET);
                    keyPress();
                    break;
            }
        }
    }

    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por: Naiara Costa ");
        System.out.println("Generation Brasil - devnaiara@gmail.com");
        System.out.println("github.com/devnaiara");
        System.out.println("*********************************************************");
    }

    public static void keyPress() {
        try {
            System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    }
}
