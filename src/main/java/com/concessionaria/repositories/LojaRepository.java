package com.concessionaria.repositories;

import com.concessionaria.entities.LojaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LojaRepository extends JpaRepository<LojaModel, UUID> {
    Optional<LojaModel> findById(UUID id);
}
