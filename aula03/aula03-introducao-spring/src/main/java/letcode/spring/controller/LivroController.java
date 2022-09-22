package letcode.spring.controller;


import letcode.spring.model.Livro;
import letcode.spring.service.LivroService;
import letcode.spring.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class LivroController {

    private LivroService livroService = new LivroService();

    @GetMapping("/livro")
    public List<Livro> getLivro() {
        return livroService.listarLivros();
    }

    @PostMapping("/livro")
    public void enviaLivro(@RequestBody Livro livro) {
        livroService.cadastrarLivro(livro.getNome(), livro.getAutor(), livro.getCodigo());
    }

    // localhost:8080/mensagem

}
