package servicos;

import classes.Emprestimo;
import classes.Livro;
import classes.Pessoa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmprestimoServico {

    private static List<Emprestimo> emprestimos = new ArrayList<>();

    PessoaServico pessoaServico = new PessoaServico();
    LivroServico livroServico = new LivroServico();

    public Emprestimo cadastrarEmprestimo(String cpf, String codigoLivro) {

        Pessoa pessoa = pessoaServico.getPessoa(cpf);

        if (pessoa == null) {
            return null;
        }
        Livro livro = livroServico.getLivro(codigoLivro);
        if (livro == null) {
            return null;
        }

        LocalDate dataDevelocao = LocalDate.now().plusDays(10);
        Emprestimo emprestimo = new Emprestimo(pessoa, livro, LocalDate.now(), dataDevelocao);

        emprestimos.add(emprestimo);
        return emprestimo;
    }

    public boolean finalizarEmprestimo(String cpf) {

        Optional<Emprestimo> op = emprestimos
                .stream()
                .filter(e -> e.getPessoa().getCpf().equals(cpf))
                .findFirst();

        Emprestimo emprestimo = op.orElse(null);
        if (emprestimo != null) {
            emprestimos.remove(emprestimo);
            return true;
        }
        return false;

    }

    public List<Emprestimo> listEmprestimos() {
        return emprestimos;
    }


}
