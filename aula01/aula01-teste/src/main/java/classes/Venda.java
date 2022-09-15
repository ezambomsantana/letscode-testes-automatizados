package classes;

import java.time.LocalDate;
import java.util.List;

public class Venda {

    private Pessoa pessoa;
    private List<Produto> produtos;
    private LocalDate dataCompra;

    public boolean adicionarProduto(Produto produto) {
        if (produto == null) { // 1
            return false; // 2
        } // 1
        if (produto.getQuantidade() == 0) { // 1
            return false;
        } // 1
        produtos.add(produto); // 1
        return true; // 1
    }

    public Double calculaValorTotal() {
        Double valorTotal = Double.valueOf(0);
        for (Produto produto : produtos) {
            valorTotal = valorTotal + (produto.getPreco() * produto.getQuantidade());
        }
        return valorTotal;
    }

    public Venda(Pessoa pessoa, List<Produto> produtos, LocalDate dataCompra) {
        this.pessoa = pessoa;
        this.produtos = produtos;
        this.dataCompra = dataCompra;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }
}
