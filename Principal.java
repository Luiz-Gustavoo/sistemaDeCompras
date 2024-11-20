package br.com.pratica.aplicacaocompras;

import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");
        double limiteDigitado = teclado.nextDouble();
        CartaoDeCredito cartao1 = new CartaoDeCredito(limiteDigitado);

        int sair = 1;
        while (sair != 0) {

            System.out.println("Digite o nome do produto: ");
            String nomeProduto = teclado.next();
            System.out.println("Digite o valor do produto: ");
            double valorProduto = teclado.nextDouble();

            Compra compra = new Compra(nomeProduto, valorProduto);

            boolean lancarcompra = cartao1.lancaCompra(compra);
            if(!lancarcompra) {
                System.out.println("Saldo insuficiente");
                break;
            } else {
                System.out.println("Compra realizada");
            }

            System.out.println("Digite 0(zero) para sair ou 1(um) para continuar");
            int escolhaUsuario = teclado.nextInt();
            sair = escolhaUsuario;
            if(escolhaUsuario != 1) {
                System.out.println("Aplicação encerrada");
            }
        }
        Collections.sort(cartao1.getCompras());

        System.out.println("\n**********");
        for(Compra item : cartao1.getCompras()) {
            System.out.println(item.getDescricao() + " - " + item.getValor());
        }
        System.out.println("**********");

        System.out.printf("\nLimite do cartão: R$ %.2f", cartao1.getSaldo());

    }
}
