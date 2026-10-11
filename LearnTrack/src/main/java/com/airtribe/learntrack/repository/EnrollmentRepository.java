package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Enrollment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnrollmentRepository {
    private List<Enrollment> enrollments = new ArrayList<>();

    public void save(Enrollment student) {
        enrollments.add(student);
    }

    public List<Enrollment> findAll() {
        return enrollments;
    }

    public Optional<Enrollment> findById(String id) {
        return enrollments.stream()
                .filter(s -> s.getId().equalsIgnoreCase(id))
                .findFirst();
    }
}
