package main;

import classes.Emprestimo;
import classes.Livro;
import classes.Pessoa;
import servicos.EmprestimoServico;
import servicos.LivroServico;
import servicos.PessoaServico;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        PessoaServico pessoaServico = new PessoaServico();
        LivroServico livroServico = new LivroServico();
        EmprestimoServico emprestimoServico = new EmprestimoServico();

        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("1) Cadastrar Pessoa");
            System.out.println("2) Listar Pessoas");
            System.out.println("3) Ver Pessoa");
            System.out.println("4) Cadastrar Livro");
            System.out.println("5) Listar Livros");
            System.out.println("6) Ver Livros");
            System.out.println("7) Cadastrar Emprestimo");
            System.out.println("8) Listar Emprestimos");
            System.out.println("9) Finalizar Emprestimo");
            String opcao = scanner.nextLine();

            if (opcao.equals("1")) {
                System.out.println("Digite o nome");
                String nome = scanner.nextLine();

                System.out.println("Digite o cpf");
                String cpf = scanner.nextLine();

                System.out.println("Digite o endereco");
                String endereco = scanner.nextLine();

                System.out.println("Digite o telefone");
                String telefone = scanner.nextLine();

                pessoaServico.cadastrarPessoa(nome, cpf, endereco, telefone);
            }

            if (opcao.equals("2")) {
                List<Pessoa> pessoas = pessoaServico.listPessoas();
                pessoas.stream().forEach(p -> System.out.println(p.getNome()));
            }

            if (opcao.equals("3")) {
                System.out.println("Digite o cpf");
                String cpf = scanner.nextLine();

                Pessoa pessoa = pessoaServico.getPessoa(cpf);
                if (pessoa != null) {
                    System.out.println(pessoa.getNome());
                } else {
                    System.out.println("Pessoa nao encontrtada!");
                }
            }

            if (opcao.equals("4")) {
                System.out.println("Digite o nome");
                String nome = scanner.nextLine();

                System.out.println("Digite o autor");
                String autor = scanner.nextLine();

                System.out.println("Digite o codigo");
                String codigo = scanner.nextLine();

                livroServico.cadastrarLivro(nome, autor, codigo);
            }

            if (opcao.equals("5")) {
                List<Livro> livros = livroServico.listLivros();
                livros.stream().forEach(p -> System.out.println(p.getNome()));
            }

            if (opcao.equals("6")) {
                System.out.println("Digite o codigo");
                String codigo = scanner.nextLine();

                Livro livro = livroServico.getLivro(codigo);
                if (livro != null) {
                    System.out.println(livro.getNome());
                } else {
                    System.out.println("Livro nao encontrtado!");
                }
            }

            if (opcao.equals("7")) {
                System.out.println("Digite o cpf");
                String cpf = scanner.nextLine();

                System.out.println("Digite o codigo");
                String codigo = scanner.nextLine();

                Emprestimo emprestimo = emprestimoServico.cadastrarEmprestimo(cpf, codigo);
                if (emprestimo == null) {
                    System.out.println("Erro ao cadastrar emprestimo!");
                }
            }

            if (opcao.equals("8")) {
                List<Emprestimo> emprestimos = emprestimoServico.listEmprestimos();
                emprestimos.stream().forEach(p -> System.out.println(p.getPessoa().getNome() + " " + p.getLivro().getNome() + " " + p.getDataEmprestimo()));
            }

        }


    }

}
