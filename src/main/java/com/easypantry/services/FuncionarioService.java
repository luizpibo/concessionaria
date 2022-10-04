package com.easypantry.services;

import com.easypantry.entities.Funcionario;
import com.easypantry.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> getAllFuncionario(){return (List<Funcionario>) funcionarioRepository.findAll();}

    public Funcionario findFuncionarioById(Long id) {
        return funcionarioRepository.findById(id).get();
    }

}
