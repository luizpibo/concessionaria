package com.easypantry.repositories;

import com.easypantry.entities.Loja;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LojaRepository extends CrudRepository<Loja, Long> {
    Optional<Loja> findById(Long id);
}
