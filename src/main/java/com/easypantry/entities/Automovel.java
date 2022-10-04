package com.easypantry.entities;


import javax.persistence.*;

@Entity
@Table(name="Automovel")
public class Automovel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "marca", nullable = false)
    private String marca;
    @Column(name = "cor", nullable = false)
    private String cor;
    @Column(name = "placa", nullable = false)
    private String placa;
    @Column(name = "classificacao", nullable = false)
    private String classificacao;
    @Column(name = "chassi", nullable = false)
    private String chassi;

    protected Automovel() {}

    public Automovel(String nome, String marca, String cor, String placa, String classificacao, String chassi) {
        this.nome = nome;
        this.marca = marca;
        this.cor = cor;
        this.placa = placa;
        this.classificacao = classificacao;
        this.chassi = chassi;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
}
