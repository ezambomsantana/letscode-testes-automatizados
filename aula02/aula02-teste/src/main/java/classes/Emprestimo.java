package classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {

    private Pessoa pessoa;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

}
