package com.easypantry.entities;

import javax.persistence.*;

@Entity
@Table(name="Loja")
public class Loja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome_fantasia;
    private String cnpj;
    private String razao_social;
    private String endereco;
    private String telefone;
    private String tipo;

    protected  Loja(){}
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Loja(String nome_fantasia, String cnpj, String razao_social, String endereco, String telefone, String tipo){
        setNome_fantasia(nome_fantasia);
        setCnpj(cnpj);
        setRazao_social(razao_social);
        setEndereco(endereco);
        setTelefone(telefone);
        setTipo(tipo);
    }

    @Override
    public String toString() {
        return String.format(
                "Loja [id=%d, nomeFantasia='%s', cnpj='%s']", id, nome_fantasia, cnpj);
    }

    @Column(name = "nome_fantasia", nullable = false)
    public String getNome_fantasia() {
        return nome_fantasia;
    }
    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    @Column(name = "cnpj", nullable = false)
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Column(name = "razao_social", nullable = false)
    public String getRazao_social() {
        return razao_social;
    }
    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    @Column(name = "endereco", nullable = false)
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Column(name = "telefone", nullable = false)
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Column(name = "tipo", nullable = false)
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}
