package classes;

import java.time.LocalDate;
import java.util.List;

public class Pessoa {

    private String nome;
    private List<String> telefones;
    private String endereco;
    private LocalDate dataNascimento;

    public Pessoa(String nome, List<String> telefones, String endereco, LocalDate dataNascimento) {
        this.nome = nome;
        this.telefones = telefones;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    public Pessoa() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
