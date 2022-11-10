package com.concessionaria.services;

import com.concessionaria.entities.FuncionarioModel;
import com.concessionaria.repositories.FuncionarioRepository;
import com.concessionaria.repositories.LojaRepository;
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
    @Autowired
    private LojaRepository lojaRepository;

    public List<FuncionarioModel> getAllByLojaId(UUID loja_id){
        var loja = lojaRepository.findById(loja_id);
        if (loja.isPresent()){
            return loja.get().getFuncionarios();
        }
        return null;
    }

    public FuncionarioModel findFuncionarioById(UUID id) {
        return funcionarioRepository.findById(id).get();
    }

}
