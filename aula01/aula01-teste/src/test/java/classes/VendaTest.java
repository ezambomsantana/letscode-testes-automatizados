package classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class VendaTest {

    @Test
    @DisplayName("Teste do caminho feliz")
    public void testAdicionaProdutoSucesso() {
        Venda venda =
                new Venda(new Pessoa(), new ArrayList<>(), LocalDate.now());

        Produto produto = new Produto("123", 20.50, 5);
        boolean teste = venda.adicionarProduto(produto);
        Assertions.assertTrue(teste);
        Assertions.assertEquals(1, venda.getProdutos().size());
    }

    @Test
    public void testAdicionaProdutoErroNull() {
        Venda venda =
                new Venda(new Pessoa(), new ArrayList<>(), LocalDate.now());

        boolean teste = venda.adicionarProduto(null);
        Assertions.assertFalse(teste);
        Assertions.assertEquals(0, venda.getProdutos().size());
    }

    @Test
    public void testAdicionaProdutoErroQuantidade() {
        Venda venda =
                new Venda(new Pessoa(), new ArrayList<>(), LocalDate.now());
        Produto produto = new Produto("1234", 10.50, 0);
        boolean teste = venda.adicionarProduto(produto);
        Assertions.assertFalse(teste);
        Assertions.assertEquals(0, venda.getProdutos().size());
    }

    @Test
    public void testCalculaValorTotalZero() {
        Venda venda =
                new Venda(new Pessoa(), new ArrayList<>(), LocalDate.now());
        Double valorTotal = venda.calculaValorTotal();
        Assertions.assertEquals(0, valorTotal);
    }

    @Test
    public void testCalculaValorTotalDiferenteZero() {
        Venda venda =
                new Venda(new Pessoa(), new ArrayList<>(), LocalDate.now());

        Produto produto = new Produto("123", 20.0, 5);
        venda.adicionarProduto(produto);

        Produto produto2 = new Produto("432", 50.0, 2);
        venda.adicionarProduto(produto2);

        Double valorTotal = venda.calculaValorTotal();
        Assertions.assertEquals(200, valorTotal);

    }


}
