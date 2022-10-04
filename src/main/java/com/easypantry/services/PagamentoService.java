package com.easypantry.services;

import com.easypantry.entities.Funcionario;
import com.easypantry.entities.Pagamento;
import com.easypantry.repositories.PagamentoRepository;

import java.util.List;

public class PagamentoService {
    private PagamentoRepository pagamentoRepository;

    public List<Pagamento> getAllPagamento(){return (List<Pagamento>) pagamentoRepository.findAll();}

    public Pagamento findPagamentoById(Long id) {
        return pagamentoRepository.findById(id).get();
    }

}
