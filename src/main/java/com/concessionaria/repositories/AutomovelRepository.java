package com.concessionaria.repositories;

import com.concessionaria.entities.AutomovelModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AutomovelRepository extends JpaRepository<AutomovelModel, UUID> {

}
