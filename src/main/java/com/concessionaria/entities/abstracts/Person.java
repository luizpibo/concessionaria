package com.concessionaria.entities.abstracts;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class Person extends DateAudit{
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
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
