package br.edu.infnet.appvenda.model.domain;

public class Moto extends Produto {
    private String marca;
    private int velocidadeMaxima;

    @Override
    public String toString() {
        return String.format("%s - %s - %s", super.toString(), marca, velocidadeMaxima);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(int velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }
}
