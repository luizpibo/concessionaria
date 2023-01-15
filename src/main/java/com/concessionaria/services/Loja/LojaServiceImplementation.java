package com.concessionaria.services.Loja;

import com.concessionaria.DTOs.AutomovelDTO;
import com.concessionaria.entities.AutomovelModel;
import com.concessionaria.exceptionhandler.exceptions.lojaController.LojaNotFoundException;
import com.concessionaria.repositories.LojaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LojaServiceImplementation implements LojaService {
    @Autowired
    LojaRepository lojaRepository;

    @Override
    public List<AutomovelDTO> getAutomoveis(UUID loja_id) {
        var loja = lojaRepository.findById(loja_id).get();

        if (loja == null) {
            throw new LojaNotFoundException();
        }

        List<AutomovelModel> automoveis = loja.getAutomoveis();
        var automoveisDTO = new ArrayList<AutomovelDTO>();

        if (automoveis.isEmpty()) {
            return automoveisDTO;
        }

        automoveis.forEach(automovelModel -> {
            var dto = new AutomovelDTO();
            BeanUtils.copyProperties(automovelModel, dto);
            automoveisDTO.add(dto);
        });

        return automoveisDTO;
    }
}
