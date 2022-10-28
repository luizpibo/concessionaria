package com.concessionaria.repositories;

import com.concessionaria.entities.PrivilegeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<PrivilegeModel, Long>{
    PrivilegeModel findByName(String name);
}