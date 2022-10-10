package com.concessionaria.repositories;

import com.concessionaria.entities.PagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<PagamentoModel, Long> {

}
