package com.concessionaria.services;

import com.concessionaria.entities.PedidoModel;
import com.concessionaria.repositories.PedidoRepository;

import java.util.List;
import java.util.UUID;

public class PedidoService {
    private PedidoRepository pedidoRepository;
    public List<PedidoModel> getAllPedidos(){return (List<PedidoModel>) pedidoRepository.findAll();}

    public PedidoModel findPedidoById(UUID id) {
        return pedidoRepository.findById(id).get();
    }
}
