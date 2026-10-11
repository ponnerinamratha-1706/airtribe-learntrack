package com.airtribe.learntrack;

import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n===== " + AppConstants.APP_NAME + " =====");
            System.out.println(MenuOptions.ADD_STUDENT + ". Add New Student");
            System.out.println(MenuOptions.VIEW_STUDENTS + ". View All Students");
            System.out.println(MenuOptions.SEARCH_STUDENT + ". Search Student by ID");
            System.out.println(MenuOptions.DEACTIVATE_STUDENT + ". Deactivate Student");
            System.out.println(MenuOptions.ADD_COURSE + ". Add New Course");
            System.out.println(MenuOptions.VIEW_COURSES + ". View All Courses");
            System.out.println(MenuOptions.TOGGLE_COURSE_STATUS + ". Toggle Course Status");
            System.out.println(MenuOptions.ENROLL_STUDENT + ". Enroll Student in Course");
            System.out.println(MenuOptions.VIEW_ENROLLMENTS + ". View Student Enrollments");
            System.out.println(MenuOptions.UPDATE_ENROLLMENT_STATUS + ". Update Enrollment Status");
            System.out.println(MenuOptions.EXIT + ". Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case MenuOptions.ADD_STUDENT:
                        System.out.print("First Name: ");
                        String fName = scanner.nextLine();
                        System.out.print("Last Name: ");
                        String lName = scanner.nextLine();
                        System.out.print("Email (press enter to skip): ");
                        String email = scanner.nextLine();
                        System.out.print("Batch Name: ");
                        String batch = scanner.nextLine();

                        Student s = email.isBlank() ?
                                studentService.addStudent(fName, lName, batch) :
                                studentService.addStudent(fName, lName, email, batch);

                        System.out.println("Student added successfully with ID: " + s.getId());
                        break;

                    case MenuOptions.VIEW_STUDENTS:
                        System.out.println("\n--- Students List ---");
                        for (Student st : studentService.listStudents()) {
                            System.out.println(st.getId() + " | " + st.getDisplayName() + " | Email: " + st.getEmail() + " | Active: " + st.isActive());
                        }
                        break;

                    case MenuOptions.SEARCH_STUDENT:
                        System.out.print("Enter Student ID: ");
                        Student found = studentService.findStudentById(scanner.nextLine());
                        System.out.println("Found: " + found.getDisplayName() + " | Email: " + found.getEmail());
                        break;

                    case MenuOptions.DEACTIVATE_STUDENT:
                        System.out.print("Enter Student ID to deactivate: ");
                        studentService.deactivateStudent(scanner.nextLine());
                        System.out.println("Student deactivated successfully.");
                        break;

                    case MenuOptions.ADD_COURSE:
                        System.out.print("Course Name: ");
                        String cName = scanner.nextLine();
                        System.out.print("Description: ");
                        String desc = scanner.nextLine();
                        System.out.print("Duration (in weeks): ");
                        int weeks = Integer.parseInt(scanner.nextLine());

                        Course c = courseService.addCourse(cName, desc, weeks);
                        System.out.println("Course added successfully with ID: " + c.getId());
                        break;

                    case MenuOptions.VIEW_COURSES:
                        System.out.println("\n--- Courses List ---");
                        for (Course cr : courseService.listCourses()) {
                            System.out.println(cr.getId() + " | " + cr.getCourseName() + " | " + cr.getDurationInWeeks() + " weeks | Active: " + cr.isActive());
                        }
                        break;

                    case MenuOptions.TOGGLE_COURSE_STATUS:
                        System.out.print("Enter Course ID to toggle status: ");
                        courseService.toggleCourseStatus(scanner.nextLine());
                        System.out.println("Course status updated.");
                        break;

                    case MenuOptions.ENROLL_STUDENT:
                        System.out.print("Enter Student ID: ");
                        String studentId = scanner.nextLine();
                        System.out.print("Enter Course ID: ");
                        String courseId = scanner.nextLine();

                        studentService.findStudentById(studentId);
                        courseService.findCourseById(courseId);

                        Enrollment en = enrollmentService.enrollStudent(studentId, courseId);
                        System.out.println("Enrollment successful! ID: " + en.getId());
                        break;

                    case MenuOptions.VIEW_ENROLLMENTS:
                        System.out.print("Enter Student ID: ");
                        String targetStudentId = scanner.nextLine();
                        System.out.println("\n--- Enrollments ---");
                        for (Enrollment e : enrollmentService.getEnrollmentsForStudent(targetStudentId)) {
                            System.out.println("Enrollment ID: " + e.getId() + " | Course ID: " + e.getCourseId() + " | Status: " + e.getStatus() + " | Date: " + e.getEnrollmentDate());
                        }
                        break;

                    case MenuOptions.UPDATE_ENROLLMENT_STATUS:
                        System.out.print("Enter Enrollment ID: ");
                        String enId = scanner.nextLine();
                        System.out.print("Enter new status (ACTIVE / COMPLETED / CANCELLED): ");
                        String status = scanner.nextLine();
                        enrollmentService.updateEnrollmentStatus(enId, status);
                        System.out.println("Enrollment status updated.");
                        break;

                    case MenuOptions.EXIT:
                        running = false;
                        System.out.println("Exiting LearnTrack. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option! Please choose a valid menu number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input format. Please enter a valid number.");
            } catch (EntityNotFoundException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
        scanner.close();
    }
}