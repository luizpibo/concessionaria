package com.concessionaria.controllers;

import com.concessionaria.entities.FuncionarioModel;
import com.concessionaria.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/funcionario")
    public List<FuncionarioModel> getAllUsers() {
        return funcionarioService.getAllFuncionario();
    }

    @GetMapping("/funcionario/{id}")
    public FuncionarioModel getFuncionarioById(@PathVariable(value = "id") Long userId){
        return funcionarioService.findFuncionarioById(userId);
    }
}
