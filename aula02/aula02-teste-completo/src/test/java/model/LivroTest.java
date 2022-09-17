package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LivroTest {

    @Test
    public void testConstrutorLivro() {

        Livro livro = new Livro("1234", "Teste", "Teste");

        Assertions.assertEquals("Teste", livro.getNome());
        Assertions.assertEquals("1234", livro.getCodigo());
        Assertions.assertEquals("Teste", livro.getAutor());

    }

}
