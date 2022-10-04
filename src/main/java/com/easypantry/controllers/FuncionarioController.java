package com.easypantry.controllers;

import com.easypantry.entities.Funcionario;
import com.easypantry.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/funcionario")
    public List<Funcionario> getAllUsers() {
        return funcionarioService.getAllFuncionario();
    }

    @GetMapping("/funcionario/{id}")
    public Funcionario getFuncionarioById(@PathVariable(value = "id") Long userId){
        return funcionarioService.findFuncionarioById(userId);
    }
}
