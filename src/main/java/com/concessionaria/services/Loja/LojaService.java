package com.concessionaria.services.Loja;

import com.concessionaria.DTOs.AutomovelDTO;

import java.util.List;
import java.util.UUID;

public interface LojaService {

    List<AutomovelDTO> getAutomoveis (UUID loja_id);
}
