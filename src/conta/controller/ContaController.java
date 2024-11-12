package conta.controller;

import java.util.ArrayList;
import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

    private ArrayList<Conta> listaContas = new ArrayList<Conta>();
    int numero = 0;

    public Conta buscarNaCollection(int numero) {
        for (var conta : listaContas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    @Override
    public void procurarPorNumero(int numero) {
        Conta conta = buscarNaCollection(numero);
        if (conta != null) {
            conta.visualizar();
        } else {
            System.out.println("A conta número: " + numero + " não foi encontrada!");
        }
    }

    @Override
    public void atualizar(Conta conta) {
        var buscaConta = buscarNaCollection(conta.getNumero());

        if (buscaConta != null) {
            listaContas.set(listaContas.indexOf(buscaConta), conta);
            System.out.println("A conta número: " + conta.getNumero() + " foi atualizada com sucesso!");
        } else {
            System.out.println("A conta número: " + conta.getNumero() + " não foi encontrada!");
        }
    }

    @Override
    public void deletar(int numero) {
        var conta = buscarNaCollection(numero);

        if (conta != null) {
            listaContas.remove(conta);  
            System.out.println("A conta número: " + numero + " foi deletada com sucesso!");
        } else {
            System.out.println("A conta número: " + numero + " não foi encontrada!");
        }
    }

    @Override
    public void listarTodas() {
        for (var conta : listaContas) {
            conta.visualizar();
        }
    }

    @Override
    public void cadastrar(Conta conta) {
        listaContas.add(conta);
        System.out.println("Conta cadastrada com sucesso!");
    }

    @Override
    public void sacar(int numero, float valor) {
        Conta conta = buscarNaCollection(numero);
        if (conta != null) {
            if (conta.sacar(valor)) {
                System.out.println("Saque realizado com sucesso!");
            } else {
                System.out.println("Saldo insuficiente para o saque.");
            }
        } else {
            System.out.println("Conta não encontrada para saque.");
        }
    }

    @Override
    public void depositar(int numero, float valor) {
        Conta conta = buscarNaCollection(numero);
        if (conta != null) {
            conta.depositar(valor);
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Conta não encontrada para depósito.");
        }
    }

    @Override
    public void transferir(int numeroOrigem, int numeroDestino, float valor) {
        Conta contaOrigem = buscarNaCollection(numeroOrigem);
        Conta contaDestino = buscarNaCollection(numeroDestino);

        if (contaOrigem != null && contaDestino != null) {
            if (contaOrigem.sacar(valor)) {
                contaDestino.depositar(valor);
                System.out.println("Transferência realizada com sucesso!");
            } else {
                System.out.println("Saldo insuficiente para a transferência.");
            }
        } else {
            System.out.println("Conta de origem ou destino não encontrada.");
        }
    }

    public int gerarNumero() {
        return ++numero;
    }
}
