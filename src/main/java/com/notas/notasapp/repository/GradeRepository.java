package com.notas.notasapp.repository;

import com.notas.notasapp.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    // Métodos adicionales si se requieren
}