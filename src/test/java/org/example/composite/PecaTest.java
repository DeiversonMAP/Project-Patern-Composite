package org.example.composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PecaTest {

    @Test
    void deveRetornarDadosDaPeca() {
        Peca peca = new Peca("Chaveiro", 12.5, 40);

        assertEquals("Chaveiro", peca.getNome());
        assertEquals(12.5, peca.getPreco(), 0.001);
        assertEquals(40, peca.getTempoImpressaoMinutos());
    }

    @Test
    void deveContarUmaPeca() {
        assertEquals(1, new Peca("Chaveiro", 12.5, 40).contarPecas());
    }

    @Test
    void deveExibirComRecuoDoNivel() {
        Peca peca = new Peca("Chaveiro", 12.5, 40);

        assertEquals("Peca Chaveiro", peca.exibir(0));
        assertEquals("    Peca Chaveiro", peca.exibir(2));
    }
}
