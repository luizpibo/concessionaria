package com.concessionaria.services.Pedido;

import com.concessionaria.DTOs.PagamentoDTO;
import com.concessionaria.DTOs.PedidoDTO;
import com.concessionaria.entities.PagamentoModel;
import com.concessionaria.entities.PedidoModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PedidoService {
    List<PedidoModel> getAllPedidos();
    PedidoModel findPedidoById(UUID id);
    Optional<PedidoDTO> findByNumero_pedido(Long numero_pedido);
    PedidoDTO createPedido(PedidoDTO pedidoDTO);
    List<PagamentoModel> verificar_pagamentos(UUID id_pedido);
    PagamentoModel adicionar_pagamento(UUID id_pedido, PagamentoDTO pagamentoDTO);
}
