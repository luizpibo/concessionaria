package com.concessionaria.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import com.sun.istack.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="Pedido")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numero_pedido", nullable = false)
    private long numero_pedido;
    @Column(name = "data_pedido", nullable = false)
    private LocalDateTime data_pedido;
    @Column(name = " data_entrega", nullable = false)
    private LocalDateTime data_entrega;
    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;
    @OneToOne
    private ClienteModel cliente;
    @OneToMany
    private List<PagamentoModel> pagamentos;
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
    public List<PagamentoModel> getPagamento() {return pagamentos;}
    public void setPagamento(List<PagamentoModel> pagamentos) {this.pagamentos = pagamentos;}
}
