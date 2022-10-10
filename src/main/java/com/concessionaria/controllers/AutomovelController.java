package com.concessionaria.controllers;

import com.concessionaria.entities.AutomovelModel;
import com.concessionaria.services.AutomovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutomovelController {
    @Autowired
    private AutomovelService automovelService;

    @GetMapping("/automovel")
    public List<AutomovelModel> getAllAutomovel() {

        return automovelService.getAllAutomovel();
    }

    @GetMapping("/automovel/{id}")
    public AutomovelModel getFuncionarioById(@PathVariable(value = "id") Long userId){
        return automovelService.findAutomovelById(userId);
    }

}
