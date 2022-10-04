package com.easypantry.controllers;

import com.easypantry.entities.Funcionario;
import com.easypantry.entities.Pedido;
import com.easypantry.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/pedido")
    public List<Pedido> getAllPedidos() {

        return pedidoService.getAllPedidos();
    }

    @GetMapping("/pedido/{id}")
    public Pedido getPedidoById(@PathVariable(value = "id") Long pedidoId){
        return pedidoService.findPedidoById(pedidoId);
    }
}
