package letcode.spring.controller;

import letcode.spring.model.DadoEmprestimo;
import letcode.spring.model.Emprestimo;
import letcode.spring.service.EmprestimoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EmprestimoController {

    private EmprestimoService emprestimoService = new EmprestimoService();

    @GetMapping("/emprestimo")
    public List<Emprestimo> listarEmprestimos() {
        return emprestimoService.listarEmprestimos();
    }

    @PostMapping("/emprestimo")
    public void salvarEmprestimos(@RequestBody DadoEmprestimo emprestimo) {
        emprestimoService.cadastrarEmprestimo(emprestimo.getCpf(), emprestimo.getCodigo());
    }

}
