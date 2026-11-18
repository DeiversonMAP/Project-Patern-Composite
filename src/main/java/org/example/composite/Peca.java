package org.example.composite;

public class Peca implements ItemCatalogo {

    private final String nome;
    private final double preco;
    private final int tempoImpressaoMinutos;

    public Peca(String nome, double preco, int tempoImpressaoMinutos) {
        this.nome = nome;
        this.preco = preco;
        this.tempoImpressaoMinutos = tempoImpressaoMinutos;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public int getTempoImpressaoMinutos() {
        return tempoImpressaoMinutos;
    }

    @Override
    public int contarPecas() {
        return 1;
    }

    @Override
    public String exibir(int nivel) {
        return "  ".repeat(nivel) + "Peca " + nome;
    }
}
