package com.easypantry.entities;

import javax.persistence.*;
import java.util.Date;

import com.sun.istack.NotNull;
import java.util.Objects;
@Entity
@Table(name="Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name = "nome", nullable = false)
    private long id_cliente;
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "numero_pedido", nullable = false)
    private long numero_pedido;
    @Column(name = "data_pedido", nullable = false)
    private Date data_pedido;
    @Column(name = " data_entrega", nullable = false)
    private Date data_entrega;
    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;

    private Pedido(@NotNull String description) {
        this.descricao = Objects.requireNonNull(description, "description must not be null");
    }
    protected  Pedido(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public long getNumero_pedido() {
        return numero_pedido;
    }

    public void setNumero_pedido(long numero_pedido) {
        this.numero_pedido = numero_pedido;
    }

    public Date getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }

    public Date getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
