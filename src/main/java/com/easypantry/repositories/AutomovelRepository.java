package com.easypantry.repositories;

import com.easypantry.entities.Automovel;
import com.easypantry.entities.Funcionario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AutomovelRepository extends CrudRepository<Automovel, Long> {
    Optional<Automovel> findById(Long id);
}
