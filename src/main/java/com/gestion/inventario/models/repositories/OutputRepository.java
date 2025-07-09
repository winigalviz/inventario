package com.gestion.inventario.models.repositories;

import com.gestion.inventario.models.entities.OutputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutputRepository extends JpaRepository<OutputEntity, Integer> {
}
