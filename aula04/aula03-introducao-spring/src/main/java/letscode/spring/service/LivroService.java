package letscode.spring.service;

import letscode.spring.db.LivroDB;
import letscode.spring.model.Livro;

import java.util.List;

public class LivroService {

    private LivroDB livroDB = new LivroDB();

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
        livroDB.adicionaLivro(livro);
        return livro;
    }

    public List<Livro> listarLivros() {
        return livroDB.listLivros();
    }

    public Livro buscarLivro(String codigo) {
        return livroDB.buscaLivro(codigo);
    }

}
