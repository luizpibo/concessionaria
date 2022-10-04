package com.easypantry.controllers;

import com.easypantry.entities.Automovel;
import com.easypantry.services.AutomovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutomovelController {
    @Autowired
    private AutomovelService automovelService;

    @GetMapping("/automovel")
    public List<Automovel> getAllAutomovel() {

        return automovelService.getAllAutomovel();
    }

    @GetMapping("/automovel/{id}")
    public Automovel getFuncionarioById(@PathVariable(value = "id") Long userId){
        return automovelService.findAutomovelById(userId);
    }

}
