package com.concessionaria.services.Pagamento;

import com.concessionaria.entities.PagamentoModel;

import java.util.List;
import java.util.UUID;

public interface PagamentoService {
    List<PagamentoModel> getAllPagamento();
    PagamentoModel findPagamentoById(UUID id);
}
