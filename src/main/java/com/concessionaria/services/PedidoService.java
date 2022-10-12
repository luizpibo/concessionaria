package com.concessionaria.services;

import com.concessionaria.entities.PedidoModel;
import com.concessionaria.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
@Service
@Transactional
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    public List<PedidoModel> getAllPedidos(){return (List<PedidoModel>) pedidoRepository.findAll();}
    public PedidoModel findPedidoById(UUID id) {
        return pedidoRepository.findById(id).get();
    }
}
