package service;

import model.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LivroService {

    private static List<Livro> livros = new ArrayList<>();

    public Livro cadastrarLivro(String nome, String autor, String codigo) {
        if (nome == null || nome.isEmpty()) {
            return null;
        }
        if (autor == null || autor.isEmpty()) {
            return null;
        }
        if (codigo == null || codigo.isEmpty()) {
            return null;
        }
        Livro livro = new Livro(codigo, nome, autor);
        livros.add(livro);
        return livro;
    }

    public List<Livro> listarLivros() {
        return livros;
    }

    public Livro buscarLivro(String codigo) {
        Optional<Livro> livro = livros
                .stream()
                .filter(l -> l.getCodigo().equals(codigo))
                .findFirst();
        if (livro.isPresent()) {
            return livro.get();
        }
        return null;
    }

}
