package servicos;

import classes.Livro;
import classes.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LivroServico {

    private static List<Livro> livros = new ArrayList<>();

    public boolean cadastrarLivro(String nome, String autor, String codigo) {
        if (nome == null || nome.isEmpty()) {
            return false;
        }
        if (autor == null || autor.isEmpty()) {
            return false;
        }
        if (codigo == null || codigo.isEmpty()) {
            return false;
        }
        Livro livro = new Livro(nome, autor, codigo);
        livros.add(livro);
        return true;
    }

    public List<Livro> listLivros() {
        return livros;
    }

    public Livro getLivro(String codigo) {
        List<Livro> pessoaList = livros
                .stream()
                .filter(p -> p.getCodigo().equals(codigo))
                .collect(Collectors.toList());
        if (pessoaList.isEmpty()) {
            return null;
        } else {
            return pessoaList.get(0);
        }
    }

}
