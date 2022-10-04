package com.easypantry.entities;

import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Automovel_pedido")
public class Automovel_pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "automovel")
    private Automovel automovel;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pedido")
    private Pedido pedido;

    //@Deprecated
    protected Automovel_pedido() {
    }

    private Automovel_pedido(@NotNull Automovel automovel, @NotNull Pedido pedido) {
        this.automovel = Objects.requireNonNull(automovel, "loja must not be null");
        this.pedido = Objects.requireNonNull(pedido, "funcionario must not be null");
    }

    public static Automovel_pedido of(@NotNull Automovel automovel, @NotNull Pedido pedido) {
        return new Automovel_pedido(automovel, pedido);
    }

    public Long getId() {
        return id;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public Pedido getPedido() {
        return pedido;
    }
}
