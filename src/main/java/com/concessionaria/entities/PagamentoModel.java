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
    @Column(name = "ID")
    private UUID id;
    @Column(name = "id_pedido")
    private UUID id_pedido;
    @Column(name = "data_vencimento")
    private LocalDateTime data_vencimento;
    @Column(name = "data_vencimento")
    private LocalDateTime data_pagamento;
    @Column(name = "tipo_pagamento")
    private int tipo_pagamento;
    protected PagamentoModel(){}
    public PagamentoModel(UUID id_pedido, LocalDateTime data_vencimento, LocalDateTime data_pagamento, int tipo_pagamento) {
        this.id_pedido = id_pedido;
        this.data_vencimento = data_vencimento;
        this.data_pagamento = data_pagamento;
        this.tipo_pagamento = tipo_pagamento;
    }
    public UUID getId() {
        return id;
    }
    public UUID getId_pedido() {
        return id_pedido;
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
