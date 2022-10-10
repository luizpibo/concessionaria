package com.concessionaria.controllers;

import com.concessionaria.entities.PedidoModel;
import com.concessionaria.services.PedidoService;
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
    public List<PedidoModel> getAllPedidos() {

        return pedidoService.getAllPedidos();
    }

    @GetMapping("/pedido/{id}")
    public PedidoModel getPedidoById(@PathVariable(value = "id") Long pedidoId){
        return pedidoService.findPedidoById(pedidoId);
    }
}
