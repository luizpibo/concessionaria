package com.concessionaria.services.Loja;

import com.concessionaria.DTOs.AutomovelDTO;
import com.concessionaria.entities.AutomovelModel;
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
        var loja = lojaRepository.findById(loja_id);
        if(loja.isPresent() && !loja.get().getAutomoveis().isEmpty()){
            List<AutomovelDTO> automoveisDto = new ArrayList<AutomovelDTO>();
            loja.get().getAutomoveis().forEach(automovelModel -> {
                var dto = new AutomovelDTO();
                BeanUtils.copyProperties(automovelModel, dto);
                automoveisDto.add(dto);
            });
            return automoveisDto;
        }
        return null;
    }
}
