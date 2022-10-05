package com.letscode.service;

import com.letscode.db.CandidatoDB;
import com.letscode.model.Candidato;

import java.util.List;

public class CandidatoService {

    private CandidatoDB candidatoDB = new CandidatoDB();

    public Candidato cadastrarCandidato(String nome, String partido, String numero, Integer votos) {

        if (nome == null || nome.isEmpty()) {
            return null;
        }
        if (numero == null || numero.isEmpty()) {
            return null;
        }
        if (partido == null || partido.isEmpty()) {
            return null;
        }
        if (votos == null || votos < 0) {
            return null;
        }
        Candidato candidato = new Candidato(nome, partido, numero, votos);
        return candidatoDB.cadastrarCandidato(candidato);
    }

    public List<Candidato> listarCandidatos() {
        return candidatoDB.listarCandidatos();
    }

    public Candidato buscaVencedor() {
        List<Candidato> candidatos = candidatoDB.listarCandidatos();
        return candidatos
                .stream()
                .sorted((c1, c2) -> c2.getVotos().compareTo(c1.getVotos()))
                .findFirst()
                .get();
    }

}
