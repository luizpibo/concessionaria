package com.concessionaria.services;

import com.concessionaria.entities.FuncionarioModel;
import com.concessionaria.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioModel> getAllFuncionario(){return (List<FuncionarioModel>) funcionarioRepository.findAll();}

    public FuncionarioModel findFuncionarioById(UUID id) {
        return funcionarioRepository.findById(id).get();
    }

}
