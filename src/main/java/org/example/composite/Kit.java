package org.example.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kit implements ItemCatalogo {

    private final String nome;
    private final double descontoPercentual;
    private final List<ItemCatalogo> itens = new ArrayList<>();

    public Kit(String nome) {
        this(nome, 0);
    }

    public Kit(String nome, double descontoPercentual) {
        this.nome = nome;
        this.descontoPercentual = descontoPercentual;
    }

    public void adicionar(ItemCatalogo item) {
        if (item == this) {
            throw new IllegalArgumentException("Um kit nao pode conter a si mesmo");
        }
        itens.add(item);
    }

    public void remover(ItemCatalogo item) {
        itens.remove(item);
    }

    public List<ItemCatalogo> getItens() {
        return Collections.unmodifiableList(itens);
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        double soma = 0;
        for (ItemCatalogo item : itens) {
            soma += item.getPreco();
        }
        return soma * (100 - descontoPercentual) / 100.0;
    }

    @Override
    public int getTempoImpressaoMinutos() {
        int total = 0;
        for (ItemCatalogo item : itens) {
            total += item.getTempoImpressaoMinutos();
        }
        return total;
    }

    @Override
    public int contarPecas() {
        int total = 0;
        for (ItemCatalogo item : itens) {
            total += item.contarPecas();
        }
        return total;
    }

    @Override
    public String exibir(int nivel) {
        StringBuilder sb = new StringBuilder();
        sb.append("  ".repeat(nivel)).append("Kit ").append(nome);
        for (ItemCatalogo item : itens) {
            sb.append("\n").append(item.exibir(nivel + 1));
        }
        return sb.toString();
    }
}
