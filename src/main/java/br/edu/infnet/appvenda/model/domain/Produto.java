package br.edu.infnet.appvenda.model.domain;

public class Produto {
    private int codigo;
    private String nome;
    private Float preco;
    private boolean estoque;

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s", codigo, nome, preco, estoque);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public boolean isEstoque() {
        return estoque;
    }

    public void setEstoque(boolean estoque) {
        this.estoque = estoque;
    }
}
