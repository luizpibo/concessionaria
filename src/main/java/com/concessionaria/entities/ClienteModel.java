package com.concessionaria.entities;

import com.concessionaria.entities.abstracts.Person;
import com.concessionaria.utilsClasses.DateAudit;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "Cliente")
public class ClienteModel extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
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
    @ManyToMany(mappedBy = "clientes")
    private List<LojaModel> lojas;
    @OneToMany
    private List<PedidoModel> pedidos;
    @OneToOne
    private UserModel user;
}
