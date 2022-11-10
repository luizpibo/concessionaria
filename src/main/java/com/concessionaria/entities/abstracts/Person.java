package com.concessionaria.entities.abstracts;

import com.concessionaria.utilsClasses.DateAudit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public abstract class Person {
    @Column(name = "nome", length = 75)
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
}
