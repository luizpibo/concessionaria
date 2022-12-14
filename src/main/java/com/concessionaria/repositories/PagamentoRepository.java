package com.concessionaria.repositories;

import com.concessionaria.entities.PagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PagamentoRepository extends JpaRepository<PagamentoModel, UUID> {

}
