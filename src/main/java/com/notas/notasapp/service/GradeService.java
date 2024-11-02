package com.notas.notasapp.service;

import com.notas.notasapp.model.Evaluation;
import com.notas.notasapp.model.Grade;
import com.notas.notasapp.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Optional<Grade> getGradeById(Long id) {
        return gradeRepository.findById(id);
    }

    public Grade saveGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade updateGrade(Grade grade) {
        Optional<Grade> gradeOptional = gradeRepository.findById(grade.getId());

        Grade buildEntity = new Grade();

        if (gradeOptional.isPresent()) {
            Grade gradeToUpdate = gradeOptional.get();
            gradeToUpdate.setScore(grade.getScore());
            gradeRepository.save(grade);
            buildEntity = gradeToUpdate;
        }
        return buildEntity;
    }

    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }
}