package com.concessionaria.services;

import com.concessionaria.entities.PagamentoModel;
import com.concessionaria.repositories.PagamentoRepository;

import java.util.List;

public class PagamentoService {
    private PagamentoRepository pagamentoRepository;

    public List<PagamentoModel> getAllPagamento(){return (List<PagamentoModel>) pagamentoRepository.findAll();}

    public PagamentoModel findPagamentoById(Long id) {
        return pagamentoRepository.findById(id).get();
    }

}
