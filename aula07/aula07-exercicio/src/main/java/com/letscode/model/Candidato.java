package com.letscode.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidato {
    private String nome;
    private String partido;
    private String numero;
    private Integer votos;
}
