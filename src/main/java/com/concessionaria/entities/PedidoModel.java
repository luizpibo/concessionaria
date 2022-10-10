package com.concessionaria.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import com.sun.istack.NotNull;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="Pedido")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @OneToOne
    @Column(name = "id_cliente", nullable = false)
    private UUID id_cliente;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numero_pedido", nullable = false)
    private long numero_pedido;
    @Column(name = "data_pedido", nullable = false)
    private LocalDateTime data_pedido;
    @Column(name = " data_entrega", nullable = false)
    private LocalDateTime data_entrega;
    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;
    @ManyToOne
    private ClienteModel cliente;
    @OneToMany
    private PagamentoModel pagamento;
    private PedidoModel(@NotNull String description) {
        this.descricao = Objects.requireNonNull(description, "description must not be null");
    }
    protected PedidoModel(){}
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(UUID id_cliente) {
        this.id_cliente = id_cliente;
    }
    public long getNumero_pedido() {
        return numero_pedido;
    }
    public void setNumero_pedido(long numero_pedido) {
        this.numero_pedido = numero_pedido;
    }
    public LocalDateTime getData_pedido() {
        return data_pedido;
    }
    public void setData_pedido(LocalDateTime data_pedido) {
        this.data_pedido = data_pedido;
    }
    public LocalDateTime getData_entrega() {
        return data_entrega;
    }
    public void setData_entrega(LocalDateTime data_entrega) {
        this.data_entrega = data_entrega;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public ClienteModel getCliente() {return cliente;}
    public void setCliente(ClienteModel cliente) {this.cliente = cliente;}
    public PagamentoModel getPagamento() {return pagamento;}
    public void setPagamento(PagamentoModel pagamento) {this.pagamento = pagamento;}
}
