package com.notas.notasapp.repository;

import com.notas.notasapp.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    // Métodos adicionales si se requieren
}