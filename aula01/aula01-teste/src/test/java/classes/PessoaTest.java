package classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PessoaTest {

    @Test
    @DisplayName("Teste do construtor de pessoa")
    public void testConstrutorPessoa() {
        Pessoa pessoa =
                new Pessoa(
                        "Eduardo", null,"Rua X", LocalDate.now());
        Assertions.assertEquals("Eduardo", pessoa.getNome());
        Assertions.assertNull(pessoa.getTelefones());
        Assertions.assertNotNull(pessoa.getEndereco());
    }

    @Test
    @DisplayName("Teste dos telefones de pessoa")
    public void testTelefones() {

        List<String> telefones = new ArrayList<>();
        telefones.add("1234");
        telefones.add("2345");
        telefones.add("5678");
        telefones.add("1234");

        Pessoa pessoa =
                new Pessoa(
                        "Eduardo", telefones,"Rua X", LocalDate.now());

        Assertions.assertEquals(4, pessoa.getTelefones().size());
        Assertions.assertEquals("1234", pessoa.getTelefones().get(0));
        for (String telefone : pessoa.getTelefones()) {
            Assertions.assertEquals(4, telefone.length());
        }
    }


}
