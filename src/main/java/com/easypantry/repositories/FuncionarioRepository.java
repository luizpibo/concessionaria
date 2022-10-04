package com.easypantry.repositories;

import com.easypantry.entities.Funcionario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
    Optional<Funcionario> findById(Long id);
}
