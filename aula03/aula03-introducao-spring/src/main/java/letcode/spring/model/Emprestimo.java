package letcode.spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Emprestimo {

    private Livro livro;
    private Pessoa pessoa;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

}
