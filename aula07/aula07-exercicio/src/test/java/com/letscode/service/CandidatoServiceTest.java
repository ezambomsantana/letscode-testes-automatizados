package com.letscode.service;

import com.letscode.db.CandidatoDB;
import com.letscode.model.Candidato;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CandidatoServiceTest {

    @InjectMocks
    private CandidatoService candidatoService;

    @Mock
    private CandidatoDB candidatoDB;

    @Test
    public void testCadastrarCandidatoSucesso() {

        Mockito.when(candidatoDB
                .cadastrarCandidato(Mockito.any()))
                .thenReturn(new Candidato("Candidato 1", "XYZ", "1", 100));

        Candidato retorno = candidatoService
                .cadastrarCandidato("Candidato 1", "XYZ", "1", 100);

        Assertions.assertEquals("Candidato 1", retorno.getNome());
        Assertions.assertEquals("XYZ", retorno.getPartido());
        Assertions.assertEquals("1", retorno.getNumero());
        Assertions.assertEquals(100, retorno.getVotos());

    }

    @Test
    public void testCadastrarCandidatoErroNomeNull() {
        Candidato retorno = candidatoService
                .cadastrarCandidato(null, "XYZ", "1", 100);
        Assertions.assertNull(retorno);
    }

    @Test
    public void testCadastrarCandidatoErroVotosNegativo() {
        Candidato retorno = candidatoService
                .cadastrarCandidato("Cadidato 1", "XYZ", "1", -100);
        Assertions.assertNull(retorno);
    }

    @Test
    public void testListarCandidatosListaVazia() {
        Mockito.when(candidatoDB.listarCandidatos())
                .thenReturn(new ArrayList<>());

        List<Candidato> lista = candidatoService.listarCandidatos();
        Assertions.assertTrue(lista.isEmpty());
    }

    @Test
    public void testListarCandidatosSucesso() {
        List<Candidato> candidatos = new ArrayList<>();
        candidatos.add(new Candidato("C1", "XYZ", "1", 100));
        candidatos.add(new Candidato("C2", "ABC", "2", 50));

        Mockito.when(candidatoDB.listarCandidatos())
                .thenReturn(candidatos);

        List<Candidato> retorno = candidatoService.listarCandidatos();
        Assertions.assertFalse(retorno.isEmpty());
        Assertions.assertEquals(2, retorno.size());
        Assertions.assertEquals("C1", retorno.get(0).getNome());
        Assertions.assertEquals("C2", retorno.get(1).getNome());
    }

    @Test
    public void testVencedor() {

        List<Candidato> candidatos = new ArrayList<>();
        candidatos.add(new Candidato("C1", "XYZ", "1", 100));
        candidatos.add(new Candidato("C2", "ABC", "2", 50));

        Mockito.when(candidatoDB.listarCandidatos())
                .thenReturn(candidatos);

        Candidato vencedor = candidatoService.buscaVencedor();
        Assertions.assertEquals("C1", vencedor.getNome());
        Assertions.assertEquals(100, vencedor.getVotos());



    }

}
