package com.concessionaria.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="Pagamento")
public class PagamentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "data_vencimento")
    private LocalDateTime data_vencimento;
    @Column(name = "data_vencimento")
    private LocalDateTime data_pagamento;
    @Column(name = "tipo_pagamento")
    private int tipo_pagamento;

    @ManyToOne
    private PedidoModel pedido;

    protected PagamentoModel(){}
    public PagamentoModel(LocalDateTime data_vencimento, LocalDateTime data_pagamento, int tipo_pagamento) {
        this.data_vencimento = data_vencimento;
        this.data_pagamento = data_pagamento;
        this.tipo_pagamento = tipo_pagamento;
    }
    public UUID getId() {
        return id;
    }
    public LocalDateTime getData_vencimento() {
        return data_vencimento;
    }
    public LocalDateTime getData_pagamento() {
        return data_pagamento;
    }
    public int getTipo_pagamento() {
        return tipo_pagamento;
    }
}
