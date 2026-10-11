package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class EnrollmentService {
    private EnrollmentRepository enrollmentRepository = new EnrollmentRepository();

    public Enrollment enrollStudent(String studentId, String courseId) {
        String id = IdGenerator.getNextEnrollmentId();
        Enrollment enrollment = new Enrollment(id, studentId, courseId);
        enrollmentRepository.save(enrollment);
        return enrollment;
    }

    public List<Enrollment> getEnrollmentsForStudent(String studentId) {
        return enrollmentRepository.findAll().stream()
                .filter(e -> e.getStudentId().equalsIgnoreCase(studentId)).toList();
    }

    public void updateEnrollmentStatus(String enrollmentId, String statusStr) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new EntityNotFoundException("Enrollment with ID " + enrollmentId + " not found."));

        try {
            EnrollmentStatus newStatus = EnrollmentStatus.valueOf(statusStr.toUpperCase());
            enrollment.setStatus(newStatus);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid status value! Use ACTIVE, COMPLETED, or CANCELLED.");
        }
    }
}
