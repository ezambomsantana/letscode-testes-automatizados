package com.letscode.db;

import com.letscode.model.Candidato;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CandidatoDB {

    private static List<Candidato> candidatos = new ArrayList<>();

    public Candidato cadastrarCandidato(Candidato candidato) {
        candidatos.add(candidato);
        return candidato;
    }

    public List<Candidato> listarCandidatos() {
        return candidatos;
    }

    public Candidato buscarCandidato(String numero) {
        Optional<Candidato> optional = candidatos
                .stream()
                .filter(candidato -> candidato.getNumero().equals(numero))
                .findFirst();
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

}
