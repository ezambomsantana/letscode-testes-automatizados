package main;

import model.Emprestimo;
import model.Livro;
import model.Pessoa;
import service.EmprestimoService;
import service.LivroService;
import service.PessoaService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PessoaService pessoaService = new PessoaService();
        LivroService livroService = new LivroService();
        EmprestimoService emprestimoService = new EmprestimoService();

        while (true) {
            System.out.println("1) Cadastrar Pessoa");
            System.out.println("2) Listar Pessoas");
            System.out.println("3) Buscar Pessoa");
            System.out.println("4) Cadastrar Livro");
            System.out.println("5) Listar Livros");
            System.out.println("6) Buscar Livro");
            System.out.println("7) Cadastrar Emprestimo");
            System.out.println("8) Listar Emprestimos");
            System.out.println("9) Devolucao");

            String opcao = scanner.nextLine();
            if (opcao.equals("1")) {
                System.out.println("Digite o nome:");
                String nome = scanner.nextLine();

                System.out.println("Digite o CPF:");
                String cpf = scanner.nextLine();

                System.out.println("Digite o endereco:");
                String endereco = scanner.nextLine();

                System.out.println("Digite o telefone:");
                String telefone = scanner.nextLine();

                Pessoa pessoa = pessoaService.cadastrarPessoa(nome, cpf, endereco, telefone);
                if (pessoa != null) {
                    System.out.println("Pessoa cadastrada com sucesso");
                } else {
                    System.out.println("Erro ao cadastrar a pessoa.");
                }
            }

            if (opcao.equals("2")) {
                List<Pessoa> pessoas = pessoaService.listaPessoas();
                pessoas.forEach(p -> System.out.println(p.getNome() + " " + p.getCpf()));
            }

            if (opcao.equals("3")) {
                System.out.println("Digite o CPF: ");
                String cpf = scanner.nextLine();

                Pessoa pessoa = pessoaService.buscaPessoa(cpf);
                if (pessoa != null) {
                    System.out.println(pessoa.getNome() + " " + pessoa.getCpf());
                } else {
                    System.out.println("Pessoa nao encontrada.");
                }
            }

            if (opcao.equals("4")) {
                System.out.println("Digite o nome:");
                String nome = scanner.nextLine();

                System.out.println("Digite o codigo:");
                String codigo = scanner.nextLine();

                System.out.println("Digite o nome do autor:");
                String autor = scanner.nextLine();

                Livro livro = livroService.cadastrarLivro(nome, autor, codigo);
                if (livro != null) {
                    System.out.println("Livro cadastrado com sucesso");
                } else {
                    System.out.println("Erro do cadastro do livro.");
                }
            }

            if (opcao.equals("5")) {
                List<Livro> livros = livroService.listarLivros();
                livros.forEach(l -> System.out.println(l.getNome()));
            }

            if (opcao.equals("6")) {
                System.out.println("Digite o codigo do livro");
                String codigo = scanner.nextLine();

                Livro livro = livroService.buscarLivro(codigo);
                if (livro != null) {
                    System.out.println(livro.getNome());
                } else {
                    System.out.println("Livro não encontrado");
                }
            }

            if (opcao.equals("7")) {
                System.out.println("Digite o CPF:");
                String cpf = scanner.nextLine();

                System.out.println("Digite o Codigo:");
                String codigo = scanner.nextLine();

                Emprestimo emprestimo = emprestimoService.cadastrarEmprestimo(cpf, codigo);
                if (emprestimo != null) {
                    System.out.println(emprestimo.getPessoa().getNome() + " " + emprestimo.getDataEmprestimo() + " " + emprestimo.getDataDevolucao());
                } else {
                    System.out.println("Erro no cadastro do emprestimo.");
                }
            }

            if (opcao.equals("8")) {
                List<Emprestimo> emprestimos = emprestimoService.listarEmprestimos();
                emprestimos.forEach(e -> System.out.println(e.getPessoa().getNome() + " " + e.getDataEmprestimo() + " " + e.getDataDevolucao()));
            }

            if (opcao.equals("9")) {
                System.out.println("Digite o CPF:");
                String cpf = scanner.nextLine();

                boolean funcionou = emprestimoService.finalizarEmprestimo(cpf);
                if (funcionou) {
                    System.out.println("Emprestimo finalizado com sucesso");
                } else {
                    System.out.println("Erro ao finalizar o emprestimo");
                }
            }


        }


    }

}
