package com.concessionaria.entities;

import com.concessionaria.utilsClasses.DateAudit;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name="Pagamento")
@EqualsAndHashCode(callSuper = true)
public class PagamentoModel extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "data_vencimento")
    @NonNull
    private LocalDateTime data_vencimento;
    @Column(name = "data_pagamento")
    @NonNull
    private LocalDateTime data_pagamento;
    @Column(name = "tipo_pagamento")
    @NonNull
    private int tipo_pagamento;

    @ManyToOne
    @JoinColumn(name = "idPedido")
    private PedidoModel pedido;

}
