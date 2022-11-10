package com.concessionaria.controllers;

import com.concessionaria.DTOs.AutomovelDTO;
import com.concessionaria.services.Loja.LojaServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/loja")
public class LojaController {
    @Autowired
    LojaServiceImplementation lojaService;

    @GetMapping("/{loja_id}/automoveis")
    public ResponseEntity<List<AutomovelDTO>> getAutomoveis (@PathVariable(value = "loja_id")UUID loja_id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(lojaService.getAutomoveis(loja_id));
    }
}
