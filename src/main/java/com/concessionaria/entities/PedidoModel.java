package com.concessionaria.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

import com.concessionaria.utilsClasses.DateAudit;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name="Pedido")
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
