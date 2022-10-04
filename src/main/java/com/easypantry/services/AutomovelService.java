package com.easypantry.services;

import com.easypantry.entities.Automovel;
import com.easypantry.entities.Funcionario;
import com.easypantry.repositories.AutomovelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomovelService {
    private AutomovelRepository automovelRepository;

    public List<Automovel> getAllAutomovel(){return (List<Automovel>) automovelRepository.findAll();}
    public Automovel findAutomovelById(Long id) {
        return automovelRepository.findById(id).get();
    }
}
