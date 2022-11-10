package com.concessionaria.services.Automovel;

import com.concessionaria.DTOs.AutomovelDTO;
import com.concessionaria.entities.AutomovelModel;
import com.concessionaria.repositories.AutomovelRepository;
import com.concessionaria.repositories.LojaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AutomovelImplementation implements AutomovelService{
    @Autowired
    private AutomovelRepository automovelRepository;

    @Autowired
    private LojaRepository lojaRepository;

    @Override
    public List<AutomovelModel> getAll(){return (List<AutomovelModel>) automovelRepository.findAll();}
    @Override
    public AutomovelModel findById(UUID id) {
        return automovelRepository.findById(id).get();
    }
    @Override
    public AutomovelModel create(AutomovelDTO automovelDTO) {
        var loja = lojaRepository.findById(automovelDTO.getLoja_id());
        if(loja.isPresent()){
            AutomovelModel newAutomovel = new AutomovelModel();
            BeanUtils.copyProperties(automovelDTO, newAutomovel);
            newAutomovel.setLoja(loja.get());
            return automovelRepository.save(newAutomovel);
        }
        return null;
    }

    @Override
    public boolean delete (UUID automovel_id){
        var automovel = automovelRepository.findById(automovel_id);
        if(automovel.isPresent()){
            automovelRepository.delete(automovel.get());
            return true;
        }
        return false;
    }
}
