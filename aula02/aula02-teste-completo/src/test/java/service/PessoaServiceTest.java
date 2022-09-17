package service;

import model.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PessoaServiceTest {

    private PessoaService pessoaService = new PessoaService();

    @Test
    public void testCadastrarPessoa() {

        Pessoa pessoa = pessoaService
                .cadastrarPessoa("Eduardo", "1234", "Rua abc", null);

        Assertions.assertEquals("Eduardo", pessoa.getNome());
        Assertions.assertEquals("1234", pessoa.getCpf());
        Assertions.assertEquals("Rua abc", pessoa.getEndereco());
        Assertions.assertNull(pessoa.getTelefone());
    }

    @Test
    public void testListarPessoas() {
        List<Pessoa> pessoas = pessoaService.listaPessoas();

        Pessoa pessoa = pessoaService
                .cadastrarPessoa("Maria", "4321", "Rua abc", null);

        Assertions.assertEquals(3, pessoas.size());
    }

    @Test
    public void testBuscarPessoa() {
        Pessoa pessoa = pessoaService
                .cadastrarPessoa("Joao", "5432", "Rua abc", null);

        Pessoa pessoaBusca = pessoaService.buscaPessoa("5432");
        Assertions.assertEquals("Joao", pessoaBusca.getNome());
    }

    @Test
    public void testCadastrarPessoaErroNomeVazio() {
        Pessoa pessoa
                = pessoaService.cadastrarPessoa("", "1234", null, null);
        Assertions.assertNull(pessoa);
    }

    @Test
    public void testCadastrarPessoaErroCpfVazio() {
        Pessoa pessoa
                = pessoaService.cadastrarPessoa("Eduardo", "", null, null);
        Assertions.assertNull(pessoa);
    }

    @Test
    public void testBuscaPessoaNaoEncontrada() {
        Pessoa pessoa = pessoaService.buscaPessoa("9876");
        Assertions.assertNull(pessoa);
    }

}
