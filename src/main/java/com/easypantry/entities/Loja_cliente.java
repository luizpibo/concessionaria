package com.easypantry.entities;

import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Loja_cliente")
public class Loja_cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "loja")
    private Loja loja;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    protected Loja_cliente() {
    }

    private Loja_cliente(@NotNull Loja loja, @NotNull Cliente cliente) {
        this.loja = Objects.requireNonNull(loja, "loja must not be null");
        this.cliente = Objects.requireNonNull(cliente, "funcionario must not be null");
    }

    public static Loja_cliente of(@NotNull Loja loja, @NotNull Cliente cliente) {
        return new Loja_cliente(loja, cliente);
    }

    public Long getId() {
        return id;
    }

    public Loja getLoja() {
        return loja;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
