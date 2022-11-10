package com.concessionaria.controllers;

import com.concessionaria.entities.FuncionarioModel;
import com.concessionaria.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/{loja_id}")
    public ResponseEntity<List<FuncionarioModel>> getAllUsers(@PathVariable(value = "loja_id") UUID lojaId) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(funcionarioService.getAllByLojaId(lojaId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioModel> getFuncionarioById(@PathVariable(value = "id") UUID userId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(funcionarioService.findFuncionarioById(userId));
    }
}
