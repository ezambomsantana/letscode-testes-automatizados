package com.letscode.controller;

import com.letscode.model.Candidato;
import com.letscode.service.CandidatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CandidatoController {

    private CandidatoService candidatoService = new CandidatoService();

    @GetMapping("/candidato")
    public List<Candidato> listCandidatos() {
        return candidatoService.listarCandidatos();
    }

    @PostMapping("/candidato")
    public Candidato salvarCandidato(@RequestBody Candidato candidato) {
        return candidatoService.cadastrarCandidato(
                candidato.getNome(), candidato.getPartido(), candidato.getNumero(), candidato.getVotos()
        );
    }

}
