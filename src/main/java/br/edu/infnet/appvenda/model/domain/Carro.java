package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TCarro")
public class Carro extends Produto {
    private int numPassageiros;
    private String modelo;

    @Override
    public String toString() {
        return String.format("%s - %s - %d", super.toString(), modelo, numPassageiros);
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
