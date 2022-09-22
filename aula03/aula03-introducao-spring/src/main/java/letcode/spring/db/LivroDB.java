package letcode.spring.db;

import letcode.spring.model.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LivroDB {

    private static List<Livro> livros = new ArrayList<>();

    public Livro adicionaLivro(Livro livro) {
        livros.add(livro);
        return livro;
    }

    public List<Livro> listLivros() {
        return livros;
    }

    public Livro buscaLivro(String codigo) {
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
