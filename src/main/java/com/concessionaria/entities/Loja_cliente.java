package com.concessionaria.entities;

import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Loja_cliente")
public class Loja_cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "loja")
    private LojaModel lojaModel;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente")
    private ClienteModel clienteModel;

    protected Loja_cliente() {
    }

    private Loja_cliente(@NotNull LojaModel lojaModel, @NotNull ClienteModel clienteModel) {
        this.lojaModel = Objects.requireNonNull(lojaModel, "loja must not be null");
        this.clienteModel = Objects.requireNonNull(clienteModel, "funcionario must not be null");
    }

    public static Loja_cliente of(@NotNull LojaModel lojaModel, @NotNull ClienteModel clienteModel) {
        return new Loja_cliente(lojaModel, clienteModel);
    }

    public UUID getId() {
        return id;
    }

    public LojaModel getLoja() {
        return lojaModel;
    }

    public ClienteModel getCliente() {
        return clienteModel;
    }
}
