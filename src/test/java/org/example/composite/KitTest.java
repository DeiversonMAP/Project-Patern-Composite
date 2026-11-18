package org.example.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KitTest {

    private Peca maria;
    private Peca jose;
    private Peca boi;
    private Peca burro;
    private Kit animais;
    private Kit presepio;

    @BeforeEach
    void montarCatalogo() {
        maria = new Peca("Maria", 25.0, 120);
        jose = new Peca("Jose", 25.0, 130);
        boi = new Peca("Boi", 10.0, 45);
        burro = new Peca("Burro", 10.0, 50);

        animais = new Kit("Animais");
        animais.adicionar(boi);
        animais.adicionar(burro);

        presepio = new Kit("Presepio", 10);
        presepio.adicionar(maria);
        presepio.adicionar(jose);
        presepio.adicionar(animais);
    }

    @Test
    void kitVazioDeveTerValorZero() {
        Kit vazio = new Kit("Vazio");

        assertEquals(0.0, vazio.getPreco(), 0.001);
        assertEquals(0, vazio.getTempoImpressaoMinutos());
        assertEquals(0, vazio.contarPecas());
    }

    @Test
    void deveSomarPrecoDosFilhos() {
        assertEquals(20.0, animais.getPreco(), 0.001);
    }

    @Test
    void deveAplicarDescontoSobreASomaDosFilhos() {
        // (25 + 25 + 20) * 90% = 63
        assertEquals(63.0, presepio.getPreco(), 0.001);
    }

    @Test
    void deveSomarTempoDeImpressaoDeTodaAArvore() {
        assertEquals(345, presepio.getTempoImpressaoMinutos());
    }

    @Test
    void deveContarPecasDeKitsAninhados() {
        assertEquals(2, animais.contarPecas());
        assertEquals(4, presepio.contarPecas());
    }

    @Test
    void deveTratarPecaEKitDaMesmaForma() {
        ItemCatalogo[] itens = {maria, animais};

        assertEquals(25.0, itens[0].getPreco(), 0.001);
        assertEquals(20.0, itens[1].getPreco(), 0.001);
    }

    @Test
    void deveRemoverItemEAtualizarOTotal() {
        presepio.remover(animais);

        assertEquals(45.0, presepio.getPreco(), 0.001);
        assertEquals(2, presepio.contarPecas());
    }

    @Test
    void deveExibirArvoreComRecuo() {
        String esperado = "Kit Presepio\n"
                + "  Peca Maria\n"
                + "  Peca Jose\n"
                + "  Kit Animais\n"
                + "    Peca Boi\n"
                + "    Peca Burro";

        assertEquals(esperado, presepio.exibir(0));
    }

    @Test
    void naoDevePermitirKitContendoASiMesmo() {
        assertThrows(IllegalArgumentException.class, () -> presepio.adicionar(presepio));
    }

    @Test
    void listaDeItensNaoDeveSerModificavelPorFora() {
        assertThrows(UnsupportedOperationException.class, () -> presepio.getItens().clear());
    }
}
