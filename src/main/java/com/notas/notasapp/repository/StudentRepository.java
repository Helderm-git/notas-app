package com.notas.notasapp.repository;

import com.notas.notasapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Métodos adicionales si se requieren
}
