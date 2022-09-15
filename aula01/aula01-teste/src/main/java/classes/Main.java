package classes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();


        Pessoa p = new Pessoa(nome, null, null, null);

        System.out.println("Nome: " + p.getNome());
    }

}
