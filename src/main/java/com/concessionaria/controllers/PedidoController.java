package com.concessionaria.controllers;

import com.concessionaria.DTOs.PedidoDTO;
import com.concessionaria.entities.PedidoModel;
import com.concessionaria.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/pedidos")
    public ResponseEntity<List<PedidoModel>> getAllPedidos() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(pedidoService.getAllPedidos());
    }

    @GetMapping("/pedido/{id}")
    public ResponseEntity<PedidoModel> getPedidoById(@PathVariable(value = "id") UUID pedidoId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(pedidoService.findPedidoById(pedidoId));
    }
    @GetMapping("/pedido/create")
    public ResponseEntity<?> createPedido(@PathVariable(value = "id") PedidoDTO pedidoDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("rada rada");
    }
}
