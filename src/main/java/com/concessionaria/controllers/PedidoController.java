package com.concessionaria.controllers;

import com.concessionaria.DTOs.PagamentoDTO;
import com.concessionaria.DTOs.PedidoDTO;
import com.concessionaria.DTOs.UserDTO;
import com.concessionaria.entities.PagamentoModel;
import com.concessionaria.entities.PedidoModel;
import com.concessionaria.services.Pedido.PedidoServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoServiceImplementation pedidoServiceImplementation;

    @GetMapping("/")
    public ResponseEntity<List<PedidoModel>> getAllPedidos() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(pedidoServiceImplementation.getAllPedidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoModel> getPedidoById(@PathVariable(value = "id") UUID pedidoId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(pedidoServiceImplementation.findPedidoById(pedidoId));
    }

    @PostMapping("/create")
    public ResponseEntity<PedidoDTO> createPedido(@Validated @RequestBody PedidoDTO pedidoDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(pedidoServiceImplementation.createPedido(pedidoDTO));
    }

    @GetMapping("/numero_pedido/{numero}")
    public ResponseEntity<?> findPedidoByNumeroPedido(@PathVariable(value = "numero") Long numero_pedido){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(pedidoServiceImplementation.findByNumero_pedido(numero_pedido));
    }

    @GetMapping("/verificar_status/{id}")
    public ResponseEntity<?> verificarStatus(@PathVariable(value = "id") UUID id_pedido){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(pedidoServiceImplementation.verificar_pagamentos(id_pedido));
    }

    @PostMapping("/adicionar_pagamentos")
    public ResponseEntity<PagamentoModel> adicionar_pagamento(@Validated @RequestBody UUID id_pedido, PagamentoDTO pagamentoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoServiceImplementation.adicionar_pagamento(id_pedido, pagamentoDTO));
    }
}
