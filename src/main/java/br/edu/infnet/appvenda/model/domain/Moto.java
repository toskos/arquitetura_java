package br.edu.infnet.appvenda.model.domain;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TMoto")
public class Moto extends Produto {

    @Size(min = 2, max = 50, message = "A marca deve ter entre {min} e {max} caracteres.")
    private String marca;
    @PositiveOrZero(message = "Velocidade máxima inválida.")
    private int velocidadeMaxima;

    @Override
    public String toString() {
        return String.format("%s - marca (%s) - velocidade maxima (%d)", super.toString(), marca, velocidadeMaxima);
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
