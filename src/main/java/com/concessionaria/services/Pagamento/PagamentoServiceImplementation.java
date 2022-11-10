package com.concessionaria.services.Pagamento;

import com.concessionaria.entities.PagamentoModel;
import com.concessionaria.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
@Service
@Transactional
public class PagamentoServiceImplementation implements PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Override
    public List<PagamentoModel> getAllPagamento(){return (List<PagamentoModel>) pagamentoRepository.findAll();}

    @Override
    public PagamentoModel findPagamentoById(UUID id) {
        return pagamentoRepository.findById(id).get();
    }

}
