package com.concessionaria.services;

import com.concessionaria.entities.PagamentoModel;
import com.concessionaria.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
@Service
@Transactional
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<PagamentoModel> getAllPagamento(){return (List<PagamentoModel>) pagamentoRepository.findAll();}

    public PagamentoModel findPagamentoById(UUID id) {
        return pagamentoRepository.findById(id).get();
    }

}
