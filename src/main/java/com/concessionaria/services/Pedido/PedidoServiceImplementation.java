package com.concessionaria.services.Pedido;

import com.concessionaria.DTOs.PagamentoDTO;
import com.concessionaria.DTOs.PedidoDTO;
import com.concessionaria.entities.PagamentoModel;
import com.concessionaria.entities.PedidoModel;
import com.concessionaria.exceptionhandler.exceptions.pedidoController.PedidoNotFoundException;
import com.concessionaria.repositories.PedidoRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PedidoServiceImplementation implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public PedidoDTO createPedido(PedidoDTO pedidoDTO) {
        PedidoModel newPedido = new PedidoModel();
        BeanUtils.copyProperties(pedidoDTO, newPedido);
        pedidoRepository.save(newPedido);
        return pedidoDTO;
    };

    @Override
    public List<PedidoModel> getAllPedidos() {
        return (List<PedidoModel>) pedidoRepository.findAll();
    }

    @Override
    public PedidoModel findPedidoById(UUID id) {
        return pedidoRepository.findById(id).get();
    }

    @Override
    public PedidoDTO findByNumero_pedido(Long numero_pedido) throws PedidoNotFoundException {
        var pedido = pedidoRepository.findByNumer_pedido(numero_pedido).get();
        if (pedido == null)
            throw new PedidoNotFoundException();

        PedidoDTO pedidoDTO = new PedidoDTO(
                pedido.getFuncionario().getId(),
                pedido.getCliente().getId(),
                pedido.getDescricao(), pedido.getAutomovel(),
                pedido.getData_entrega().until(LocalDateTime.now(), ChronoUnit.DAYS));
        BeanUtils.copyProperties(pedido, pedidoDTO);
        return pedidoDTO;
    }

    @Override
    public List<PagamentoModel> verificar_pagamentos(UUID id_pedido) throws PedidoNotFoundException {
        var pedido = pedidoRepository.findById(id_pedido).get();
        if (pedido == null)
            throw new PedidoNotFoundException();
        return pedido.getPagamentos();
    }

    @Override
    public PagamentoModel adicionar_pagamento(UUID id_pedido, PagamentoDTO pagamentoDTO)
            throws PedidoNotFoundException {
        var pedido = pedidoRepository.findById(id_pedido).get();

        if (pedido == null)
            throw new PedidoNotFoundException();

        var pagamentos = pedido.getPagamentos();
        PagamentoModel newPagamento = new PagamentoModel();
        BeanUtils.copyProperties(pagamentoDTO, newPagamento);
        pagamentos.add(newPagamento);
        pedido.setPagamentos(pagamentos);
        return newPagamento;
    }
}
