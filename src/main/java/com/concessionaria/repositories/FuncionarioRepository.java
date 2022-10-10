package com.concessionaria.repositories;

import com.concessionaria.entities.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, UUID> {
    Optional<FuncionarioModel> findById(UUID id);
}
