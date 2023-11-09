package br.edu.infnet.appvenda.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TVendedor",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"cpf"}),
                @UniqueConstraint(columnNames = {"email"})
        })
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 2, max = 50, message = "O nome deve ter entre {min} e {max} caracteres.")
    private String nome;
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF invalido.")
    @Column(unique = true)
    private String cpf;
    @Size(min = 2, max = 50, message = "O e-mail deve ter entre {min} e {max} caracteres.")
    @Column(unique = true)
    private String email;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "idVendedor")
    private List<Produto> produtos;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;

    @Override
    public String toString() {
        return String.format("id (%d) - nome (%s) - cpf (%s) - email (%s) - endereco (%s) - produtos (%d)", id, nome, cpf, email,
                endereco,
                produtos != null ? produtos.size() : 0);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
