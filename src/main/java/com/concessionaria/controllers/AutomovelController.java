package com.concessionaria.controllers;

import com.concessionaria.DTOs.AutomovelDTO;
import com.concessionaria.entities.AutomovelModel;
import com.concessionaria.services.Automovel.AutomovelImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/automovel")
public class AutomovelController {
    @Autowired
    private AutomovelImplementation automovelImplementation;

    @GetMapping("/")
    public ResponseEntity<List<AutomovelModel>> getAllAutomovel() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(automovelImplementation.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutomovelModel> getFuncionarioById(@PathVariable(value = "id") UUID userId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(automovelImplementation.findById(userId));
    }

    @PostMapping("/create")
    public ResponseEntity<AutomovelModel> createNewAutomovel(@Validated @RequestBody AutomovelDTO automovelDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(automovelImplementation.create(automovelDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAutomovel(@PathVariable(value = "id")UUID automovel_id ){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(automovelImplementation.delete(automovel_id));
    }
}
