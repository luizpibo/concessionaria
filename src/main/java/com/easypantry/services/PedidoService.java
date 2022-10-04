package com.easypantry.services;

import com.easypantry.entities.Pagamento;
import com.easypantry.entities.Pedido;
import com.easypantry.repositories.PagamentoRepository;
import com.easypantry.repositories.PedidoRepository;

import java.util.List;

public class PedidoService {
    private PedidoRepository pedidoRepository;
    public List<Pedido> getAllPedidos(){return (List<Pedido>) pedidoRepository.findAll();}

    public Pedido findPedidoById(Long id) {
        return pedidoRepository.findById(id).get();
    }
}
