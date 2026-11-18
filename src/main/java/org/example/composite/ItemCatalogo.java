package org.example.composite;

public interface ItemCatalogo {

    String getNome();

    double getPreco();

    int getTempoImpressaoMinutos();

    int contarPecas();

    String exibir(int nivel);
}
