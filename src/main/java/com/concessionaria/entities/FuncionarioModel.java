package com.concessionaria.entities;

import com.concessionaria.entities.abstracts.DateAudit;
import com.concessionaria.entities.abstracts.Person;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "Funcionario")
public class FuncionarioModel extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "cargo")
    @NonNull
    private String cargo;
    @ManyToOne
    private LojaModel loja;
    @OneToOne
    private UserModel user;

}

