package letcode.spring.service;


import letcode.spring.model.Emprestimo;
import letcode.spring.model.Livro;
import letcode.spring.model.Pessoa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmprestimoService {

    private static List<Emprestimo> emprestimos = new ArrayList<>();

    private PessoaService pessoaService = new PessoaService();
    private LivroService livroService = new LivroService();

    public Emprestimo cadastrarEmprestimo(String cpf, String codigo) {
        Pessoa pessoa = pessoaService.buscaPessoa(cpf);
        if (pessoa == null) {
            return null;
        }

        Livro livro = livroService.buscarLivro(codigo);
        if (livro == null) {
            return null;
        }

        LocalDate dataEmprestimo = LocalDate.now();
        LocalDate dataDevolucao = dataEmprestimo.plusDays(10);

        Emprestimo emprestimo = new Emprestimo(livro, pessoa, dataEmprestimo, dataDevolucao);
        emprestimos.add(emprestimo);
        return emprestimo;
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimos;
    }

    public boolean finalizarEmprestimo(String cpf) {
        Optional<Emprestimo> emprestimo = emprestimos
                .stream()
                .filter(e -> e.getPessoa().getCpf().equals(cpf))
                .findFirst();

        if (emprestimo.isPresent()) {
            Emprestimo emp = emprestimo.get();
            emprestimos.remove(emp);
            return true;
        }
        return false;
    }



}
