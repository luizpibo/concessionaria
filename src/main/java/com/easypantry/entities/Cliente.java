package com.easypantry.entities;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "nome", length = 75)
    private String nome;

    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "telefone", length = 11)
    private String telefone;

    @Column(name = "rg", length = 7)
    private String rg;

    @Column(name = "data_nascimento")
    private Date data_nascimento;

    @Column(name = "endereco")
    private String endereco;

    protected  Cliente(){}

    public Cliente(String nome, String cpf, String telefone, String rg, Date data_nascimento, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.rg = rg;
        this.data_nascimento = data_nascimento;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getRg() {
        return rg;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public String getEndereco() {
        return endereco;
    }
}
