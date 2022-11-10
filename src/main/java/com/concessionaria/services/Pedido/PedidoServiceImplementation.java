package com.concessionaria.services.Pedido;

import com.concessionaria.DTOs.PagamentoDTO;
import com.concessionaria.DTOs.PedidoDTO;
import com.concessionaria.entities.AutomovelModel;
import com.concessionaria.entities.PagamentoModel;
import com.concessionaria.entities.PedidoModel;
import com.concessionaria.repositories.PedidoRepository;
import jdk.jshell.execution.Util;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@Transactional
public class PedidoServiceImplementation implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Override
    public PedidoDTO createPedido(PedidoDTO pedidoDTO){
        PedidoModel newPedido = new PedidoModel();
        BeanUtils.copyProperties(pedidoDTO, newPedido);
        pedidoRepository.save(newPedido);
        return pedidoDTO;
    };
    @Override
    public List<PedidoModel> getAllPedidos(){return (List<PedidoModel>) pedidoRepository.findAll();}
    @Override
    public PedidoModel findPedidoById(UUID id) {
        return pedidoRepository.findById(id).get();
    }
    @Override
    public Optional<PedidoDTO> findByNumero_pedido(Long numero_pedido){
        var newPedido = pedidoRepository.findByNumer_pedido(numero_pedido).get();
        if(newPedido != null){
            PedidoDTO pedidoDTO = new PedidoDTO(newPedido.getFuncionario().getId(), newPedido.getCliente().getId(), newPedido.getDescricao(), newPedido.getAutomovel(), newPedido.getData_entrega().until(LocalDateTime.now(), ChronoUnit.DAYS));
            return Optional.of(pedidoDTO);
        }
        return null;
    }
    @Override
    public List<PagamentoModel> verificar_pagamentos(UUID id_pedido){
        var pedido = pedidoRepository.findById(id_pedido).get();
        return pedido.getPagamentos();
    }

    @Override
    public PagamentoModel adicionar_pagamento(UUID id_pedido, PagamentoDTO pagamentoDTO) {
        var pedido = pedidoRepository.findById(id_pedido);
        if(pedido.isPresent()){
            var pagamentos = pedido.get().getPagamentos();
            PagamentoModel newPagamento = new PagamentoModel();
            BeanUtils.copyProperties(pagamentoDTO, newPagamento);
            pagamentos.add(newPagamento);
            pedido.get().setPagamentos(pagamentos);
            return newPagamento;
        }
        return null;
    }
}
