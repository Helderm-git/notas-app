package com.notas.notasapp.service;

import com.notas.notasapp.model.Evaluation;
import com.notas.notasapp.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;

    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.findAll();
    }

    public Optional<Evaluation> getEvaluationById(Long id) {
        return evaluationRepository.findById(id);
    }

    public Evaluation saveEvaluation(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    public Evaluation updateEvaluation(Evaluation evaluation) {
        Optional<Evaluation> optionalEvaluation = evaluationRepository.findById(evaluation.getId());
        Evaluation buildEntity = new Evaluation();
        if (optionalEvaluation.isPresent()) {
            Evaluation evaluationToUpdate = optionalEvaluation.get();
            evaluationToUpdate.setType(evaluation.getType());
            evaluationToUpdate.setMaxScore(evaluation.getMaxScore());
            evaluationRepository.save(evaluation);
            buildEntity = evaluationToUpdate;
        }
        return buildEntity;
    }


    public void deleteEvaluation(Long id) {
        evaluationRepository.deleteById(id);
    }
}
