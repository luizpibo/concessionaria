package com.concessionaria.repositories;

import com.concessionaria.entities.AutomovelModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutomovelRepository extends JpaRepository<AutomovelModel, Long> {
    Optional<AutomovelModel> findById(Long id);
}
