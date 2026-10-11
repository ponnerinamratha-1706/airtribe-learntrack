package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseRepository {
    private List<Course> courses = new ArrayList<>();

    public void save(Course student) {
        courses.add(student);
    }

    public List<Course> findAll() {
        return courses;
    }

    public Optional<Course> findById(String id) {
        return courses.stream()
                .filter(s -> s.getId().equalsIgnoreCase(id))
                .findFirst();
    }
}
