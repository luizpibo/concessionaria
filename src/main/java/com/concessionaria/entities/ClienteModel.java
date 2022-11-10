package com.concessionaria.entities;

import com.concessionaria.entities.abstracts.DateAudit;
import com.concessionaria.entities.abstracts.Person;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "Cliente")
@NoArgsConstructor
public class ClienteModel extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "nome", length = 75)
    @ManyToMany(mappedBy = "clientes")
    private List<LojaModel> lojas;
    @OneToMany
    private List<PedidoModel> pedidos;
    @OneToOne
    private UserModel user;

}
