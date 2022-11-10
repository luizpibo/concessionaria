package com.concessionaria.services.Automovel;

import com.concessionaria.DTOs.AutomovelDTO;
import com.concessionaria.entities.AutomovelModel;

import java.util.List;
import java.util.UUID;

public interface AutomovelService {
    List<AutomovelModel> getAll();
    AutomovelModel findById(UUID id);
    AutomovelModel create(AutomovelDTO automovelDTO);
    boolean delete (UUID automovel_id);
}
