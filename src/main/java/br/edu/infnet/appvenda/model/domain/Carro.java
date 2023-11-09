package br.edu.infnet.appvenda.model.domain;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TCarro")
public class Carro extends Produto {

    @PositiveOrZero(message = "Numero de passageiros inválido.")
    private int numPassageiros;
    @Size(min = 2, max = 50, message = "O modelo deve ter entre {min} e {max} caracteres.")
    private String modelo;

    @Override
    public String toString() {
        return String.format("%s - modelo (%s) - numero de passageiros (%d)", super.toString(), modelo, numPassageiros);
    }

    public int getNumPassageiros() {
        return numPassageiros;
    }

    public void setNumPassageiros(int numPassageiros) {
        this.numPassageiros = numPassageiros;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
