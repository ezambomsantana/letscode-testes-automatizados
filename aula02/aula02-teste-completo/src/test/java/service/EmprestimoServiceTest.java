package service;

import model.Emprestimo;
import model.Livro;
import model.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class EmprestimoServiceTest {

    @InjectMocks
    private EmprestimoService emprestimoService;

    @Mock
    private PessoaService pessoaService;

    @Mock
    private LivroService livroService;

    @Test
    public void testCadastrarEmprestimo() {

        Mockito.when(pessoaService.buscaPessoa("1234"))
                .thenReturn(new Pessoa("Eduardo", "1234", "Rua abc", "1234"));
        Mockito.when(livroService.buscarLivro("1234"))
                .thenReturn(new Livro("1234", "Teste", "Test"));

        Emprestimo emprestimo
                = emprestimoService.cadastrarEmprestimo("1234", "1234");

        Assertions.assertEquals("Eduardo", emprestimo.getPessoa().getNome());
        Assertions.assertEquals("Teste", emprestimo.getLivro().getNome());
        Assertions.assertEquals(LocalDate.now(), emprestimo.getDataEmprestimo());
        Assertions.assertEquals(LocalDate.now().plusDays(10), emprestimo.getDataDevolucao());

    }

}
