package com.concessionaria.services;

import com.concessionaria.entities.FuncionarioModel;
import com.concessionaria.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioModel> getAllFuncionario(){return (List<FuncionarioModel>) funcionarioRepository.findAll();}

    public FuncionarioModel findFuncionarioById(Long id) {
        return funcionarioRepository.findById(id).get();
    }

}
