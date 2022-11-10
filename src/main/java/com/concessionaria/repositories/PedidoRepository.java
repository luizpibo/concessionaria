package com.concessionaria.repositories;

import com.concessionaria.entities.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;

import java.util.Optional;
import java.util.UUID;

public interface PedidoRepository extends JpaRepository<PedidoModel, UUID> {
    Optional<PedidoModel> findByNumer_pedido(Long numero_pedido);
    Optional<PedidoModel> findById(UUID id);
}
