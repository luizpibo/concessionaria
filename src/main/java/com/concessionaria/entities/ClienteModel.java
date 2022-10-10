package com.concessionaria.entities;

import org.springframework.data.annotation.Id;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Cliente")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "nome", length = 75)
    private String nome;
    @Column(name = "cpf", length = 11)
    private String cpf;
    @Column(name = "telefone", length = 11)
    private String telefone;
    @Column(name = "rg", length = 7)
    private String rg;
    @Column(name = "data_nascimento")
    private LocalDateTime data_nascimento;
    @Column(name = "endereco")
    private String endereco;
    @ManyToMany(mappedBy = "clientes")
    private List<LojaModel> Lojas;
    @OneToMany
    private List<PedidoModel> pedidos;
    @OneToOne
    private UserModel user;
    protected ClienteModel(){}
    public ClienteModel(String nome, String cpf, String telefone, String rg, LocalDateTime data_nascimento, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.rg = rg;
        this.data_nascimento = data_nascimento;
        this.endereco = endereco;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
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
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public LocalDateTime getData_nascimento() {
        return data_nascimento;
    }
    public void setData_nascimento(LocalDateTime data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
    public String getEndereco() {return endereco;}
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public List<LojaModel> getLojas() {return Lojas;}
    public void setLojas(List<LojaModel> lojas) {Lojas = lojas;}
    public List<PedidoModel> getPedidos() {return pedidos;}
    public void setPedidos(List<PedidoModel> pedidos) {this.pedidos = pedidos;}
    public UserModel getUser() {return user;}
    public void setUser(UserModel user) {this.user = user;}
}
