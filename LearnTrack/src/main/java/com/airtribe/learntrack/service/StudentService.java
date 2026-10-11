package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class StudentService {
    private StudentRepository studentRepository = new StudentRepository();

    public Student addStudent(String firstName, String lastName, String email, String batch) {
        String id = IdGenerator.getNextStudentId();
        Student student = new Student(id, firstName, lastName, email, batch);
        studentRepository.save(student);
        return student;
    }

    // Overloaded method without email
    public Student addStudent(String firstName, String lastName, String batch) {
        String id = IdGenerator.getNextStudentId();
        Student student = new Student(id, firstName, lastName, batch);
        studentRepository.save(student);
        return student;
    }

    public List<Student> listStudents() {
        return studentRepository.findAll();
    }

    public Student findStudentById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student with ID " + id + " not found."));
    }

    public void deactivateStudent(String id) {
        Student student = findStudentById(id);
        student.setActive(false);
    }
}
