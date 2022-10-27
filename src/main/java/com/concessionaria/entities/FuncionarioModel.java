package com.concessionaria.entities;

import com.concessionaria.utilsClasses.DateAudit;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Funcionario")
@EqualsAndHashCode(callSuper = true)
public class FuncionarioModel extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "nome", length = 40)
    @NonNull
    private String nome;
    @Column(name = "cpf", length = 11)
    @NonNull
    private String cpf;
    @Column(name = "telefone", length = 11)
    @NonNull
    private String telefone;
    @Column(name = "rg", length = 7)
    @NonNull
    private String rg;
    @Column(name = "data_nascimento")
    @NonNull
    private LocalDateTime data_nascimento;
    @Column(name = "endereco")
    @NonNull
    private String endereco;
    @Column(name = "cargo")
    @NonNull
    private String cargo;
    @ManyToOne
    private LojaModel loja;
    @OneToOne
    private UserModel user;

}
