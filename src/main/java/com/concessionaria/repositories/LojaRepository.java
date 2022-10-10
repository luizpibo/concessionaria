package com.concessionaria.repositories;

import com.concessionaria.entities.LojaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LojaRepository extends JpaRepository<LojaModel, Long> {
    Optional<LojaModel> findById(Long id);
}
