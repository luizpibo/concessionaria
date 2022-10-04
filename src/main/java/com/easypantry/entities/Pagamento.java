package com.easypantry.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pedido")
    private long id_pedido;

    @Column(name = "data_vencimento")
    private Date data_vencimento;

    @Column(name = "data_vencimento")
    private Date data_pagamento;

    @Column(name = "tipo_pagamento")
    private int tipo_pagamento;

    protected  Pagamento(){}

    public Pagamento(long id_pedido, Date data_vencimento, Date data_pagamento, int tipo_pagamento) {
        this.id_pedido = id_pedido;
        this.data_vencimento = data_vencimento;
        this.data_pagamento = data_pagamento;
        this.tipo_pagamento = tipo_pagamento;
    }

    public long getId() {
        return id;
    }

    public long getId_pedido() {
        return id_pedido;
    }

    public Date getData_vencimento() {
        return data_vencimento;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public int getTipo_pagamento() {
        return tipo_pagamento;
    }
}
