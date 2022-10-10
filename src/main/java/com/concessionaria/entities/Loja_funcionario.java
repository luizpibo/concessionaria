package com.concessionaria.entities;

import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Loja_funcionario")
public class Loja_funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_loja")
    private LojaModel lojaModel;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_funcionario")
    private FuncionarioModel funcionarioModel;

    @Column(name="observacao", length = 100)
    private  String observacao;



    protected Loja_funcionario() {
    }

    private Loja_funcionario(@NotNull LojaModel lojaModel, @NotNull FuncionarioModel funcionarioModel, String observacao) {
        this.lojaModel = Objects.requireNonNull(lojaModel, "loja must not be null");
        this.funcionarioModel = Objects.requireNonNull(funcionarioModel, "funcionario must not be null");
        this.observacao = observacao;
    }

    public static Loja_funcionario of(@NotNull LojaModel lojaModel, @NotNull FuncionarioModel funcionarioModel, String observacao) {
        return new Loja_funcionario(lojaModel, funcionarioModel, observacao);
    }

    public UUID getId() {
        return id;
    }

    public LojaModel getLoja() {
        return lojaModel;
    }

    public FuncionarioModel getFuncionario() {
        return funcionarioModel;
    }
}
