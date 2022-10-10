package com.concessionaria.controllers;

import com.concessionaria.entities.AutomovelModel;
import com.concessionaria.services.AutomovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class AutomovelController {
    @Autowired
    private AutomovelService automovelService;

    @GetMapping("/automovel")
    public ResponseEntity<List<AutomovelModel>> getAllAutomovel() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(automovelService.getAllAutomovel());
    }

    @GetMapping("/automovel/{id}")
    public ResponseEntity<AutomovelModel> getFuncionarioById(@PathVariable(value = "id") UUID userId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(automovelService.findAutomovelById(userId));
    }

}
