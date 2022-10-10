package com.concessionaria.entities;

import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Automovel_pedido")
public class Automovel_pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "automovel")
    private AutomovelModel automovelModel;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pedido")
    private PedidoModel pedidoModel;

    //@Deprecated
    protected Automovel_pedido() {
    }

    private Automovel_pedido(@NotNull AutomovelModel automovelModel, @NotNull PedidoModel pedidoModel) {
        this.automovelModel = Objects.requireNonNull(automovelModel, "loja must not be null");
        this.pedidoModel = Objects.requireNonNull(pedidoModel, "funcionario must not be null");
    }

    public static Automovel_pedido of(@NotNull AutomovelModel automovelModel, @NotNull PedidoModel pedidoModel) {
        return new Automovel_pedido(automovelModel, pedidoModel);
    }

    public UUID getId() {
        return id;
    }

    public AutomovelModel getAutomovel() {
        return automovelModel;
    }

    public PedidoModel getPedido() {
        return pedidoModel;
    }
}
