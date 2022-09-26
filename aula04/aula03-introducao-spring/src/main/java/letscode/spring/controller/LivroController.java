package letscode.spring.controller;


import letscode.spring.model.Livro;
import letscode.spring.service.LivroService;
import org.springframework.web.bind.annotation.*;

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
    public Livro enviaLivro(@RequestBody Livro livro) {
        return livroService.cadastrarLivro(livro.getNome(), livro.getAutor(), livro.getCodigo());
    }


}
