package com.concessionaria.entities;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="Loja")
public class LojaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "nome_fantasia", nullable = false)
    private String nome_fantasia;
    @Column(name = "cnpj", nullable = false)
    private String cnpj;
    @Column(name = "razao_social", nullable = false)
    private String razao_social;
    @Column(name = "endereco", nullable = false)
    private String endereco;
    @Column(name = "telefone", nullable = false)
    private String telefone;
    @Column(name = "tipo", nullable = false)
    private String tipo;
    @OneToOne
    private UserModel user;
    @OneToMany
    private List<FuncionarioModel> funcionarios;

    @ManyToMany
    @JoinTable(name = "Loja_Cliente",
            joinColumns = @JoinColumn(name = "idCliente"),
            inverseJoinColumns = @JoinColumn(name ="idLoja"))
    private List<ClienteModel> clientes;
    protected LojaModel(){}
    public LojaModel(String nome_fantasia, String cnpj, String razao_social, String endereco, String telefone, String tipo){
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
    public UUID getId() {return id;}
    public void setId(UUID id) {this.id = id;}
    public String getNome_fantasia() {
        return nome_fantasia;
    }
    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getRazao_social() {
        return razao_social;
    }
    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public UserModel getUser() {return user;}
    public void setUser(UserModel user) {this.user = user;}
    public List<FuncionarioModel> getFuncionarios() {return funcionarios;}
    public void setFuncionarios(List<FuncionarioModel> funcionarios) {this.funcionarios = funcionarios;}
    public List<ClienteModel> getClientes() {return clientes;}
    public void setClientes(List<ClienteModel> clientes) {this.clientes = clientes;}
}
