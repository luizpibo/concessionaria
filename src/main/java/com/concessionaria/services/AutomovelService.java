package com.concessionaria.services;

import com.concessionaria.entities.AutomovelModel;
import com.concessionaria.repositories.AutomovelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AutomovelService {
    private AutomovelRepository automovelRepository;

    public List<AutomovelModel> getAllAutomovel(){return (List<AutomovelModel>) automovelRepository.findAll();}
    public AutomovelModel findAutomovelById(UUID id) {
        return automovelRepository.findById(id).get();
    }
}
