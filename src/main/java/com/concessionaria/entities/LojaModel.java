package com.concessionaria.entities;

import com.concessionaria.entities.abstracts.DateAudit;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name="Loja")
public class LojaModel extends DateAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    @NonNull
    private String nome_fantasia;
    @Column(nullable = false)
    @NonNull
    private String cnpj;
    @Column(nullable = false)
    @NonNull
    private String razao_social;
    @Column(nullable = false)
    @NonNull
    private String endereco;
    @Column(nullable = false)
    @NonNull
    private String telefone;
    @Column(nullable = false)
    @NonNull
    private String tipo;
    @OneToOne
    private UserModel admin;
    @OneToMany
    private List<FuncionarioModel> funcionarios;

    @OneToMany
    private List<AutomovelModel> automoveis;
    @ManyToMany
    @JoinTable(name = "Loja_Cliente",
            joinColumns = @JoinColumn(name = "idCliente"),
            inverseJoinColumns = @JoinColumn(name ="idLoja"))
    private List<ClienteModel> clientes;

}
