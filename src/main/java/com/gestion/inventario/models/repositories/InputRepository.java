package com.gestion.inventario.models.repositories;

import com.gestion.inventario.models.entities.InputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputRepository extends JpaRepository<InputEntity, Integer> {
}
