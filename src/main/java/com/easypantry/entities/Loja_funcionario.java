package com.easypantry.entities;

import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Loja_funcionario")
public class Loja_funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_loja")
    private Loja loja;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    @Column(name="observacao", length = 100)
    private  String observacao;



    protected Loja_funcionario() {
    }

    private Loja_funcionario(@NotNull Loja loja, @NotNull Funcionario funcionario, String observacao) {
        this.loja = Objects.requireNonNull(loja, "loja must not be null");
        this.funcionario = Objects.requireNonNull(funcionario, "funcionario must not be null");
        this.observacao = observacao;
    }

    public static Loja_funcionario of(@NotNull Loja loja, @NotNull Funcionario funcionario, String observacao) {
        return new Loja_funcionario(loja, funcionario, observacao);
    }

    public Long getId() {
        return id;
    }

    public Loja getLoja() {
        return loja;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
}
