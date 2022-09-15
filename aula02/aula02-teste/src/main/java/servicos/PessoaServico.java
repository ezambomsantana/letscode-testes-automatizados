package servicos;

import classes.Emprestimo;
import classes.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PessoaServico {

    private static List<Pessoa> pessoas = new ArrayList<>();

    public boolean cadastrarPessoa(String nome, String cpf, String endereco, String telefone) {
        if (nome == null || nome.isEmpty()) {
            return false;
        }
        if (cpf == null || cpf.isEmpty()) {
            return false;
        }
        if (endereco == null || endereco.isEmpty()) {
            return false;
        }
        if (telefone == null || telefone.isEmpty()) {
            return false;
        }
        Pessoa pessoa = new Pessoa(nome, cpf, endereco, telefone);
        pessoas.add(pessoa);
        return true;
    }

    public List<Pessoa> listPessoas() {
        return pessoas;
    }

    public Pessoa getPessoa(String cpf) {
        List<Pessoa> pessoaList = pessoas
                .stream()
                .filter(p -> p.getCpf().equals(cpf))
                .collect(Collectors.toList());
        if (pessoaList.isEmpty()) {
            return null;
        } else {
            return pessoaList.get(0);
        }
    }


}
