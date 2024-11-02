package com.notas.notasapp.service;

import com.notas.notasapp.model.Student;
import com.notas.notasapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student saveUpdateStudent(Student student) {
        Optional<Student> newStudent = studentRepository.findById(student.getId());
        Student buildEntity = new Student();
        if(newStudent.isPresent()) {
            Student updatedStudent = newStudent.get();
            updatedStudent.setName(student.getName());
            updatedStudent.setStudentId(student.getStudentId());
            buildEntity.setStudentId(updatedStudent.getStudentId());
            buildEntity.setName(updatedStudent.getName());
            studentRepository.save(student);
        }
        return buildEntity;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}