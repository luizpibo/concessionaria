package com.concessionaria.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

import com.concessionaria.utilsClasses.DateAudit;
import com.sun.istack.NotNull;
import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name="Pedido")
@EqualsAndHashCode(callSuper = true)
public class PedidoModel extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long numero_pedido;
    @Column(nullable = false)
    @NonNull
    private LocalDateTime data_pedido;
    @Column(nullable = false)
    @NonNull
    private LocalDateTime data_entrega;
    @Column(nullable = false)
    @NonNull
    private String descricao;
    @OneToOne
    private ClienteModel cliente;
    @OneToMany
    private List<PagamentoModel> pagamentos;
}
