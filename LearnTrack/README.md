# LearnTrack [Student & Course Management System]

**LearnTrack** is a robust console-based Student & Course Management System built using **Core Java**. It is designed as part of the backend engineering curriculum to practice core Java fundamentals, object-oriented programming (OOP) principles, collections, modular packaging, and clean architecture.

---

## 🚀 Features

- **Student Management:** Add new students, view the full student directory, search for students by unique ID, and safely deactivate students (preserving history by setting status to inactive).
- **Course Management:** Create courses with specified durations and descriptions, view all available courses, and toggle course statuses.
- **Enrollment Management:** Enroll active students into active courses, track student enrollments, and update enrollment statuses (`ACTIVE`, `COMPLETED`, `CANCELLED`).
- **Robust Exception Handling:** Gracefully handles invalid inputs and non-existent entity IDs using custom exceptions (`EntityNotFoundException`) without crashing the application.
- **Clean Architecture:** Fully separated into `entity`, `service`, `constants`, `enums`, `util`, and `ui` packages following industry best practices.

---

## 📁 Project Package Structure

```text
com.airtribe.learntrack/
│
├── constants/
│   ├── AppConstants.java
│   └── MenuOptions.java
│
├── enums/
│   ├── EnrollmentStatus.java
│   └── CourseStatus.java
│
├── entity/
│   ├── Person.java
│   ├── Student.java
│   ├── Course.java
│   └── Enrollment.java
│
├── service/
│   ├── StudentService.java
│   ├── CourseService.java
│   └── EnrollmentService.java
│
├── exception/
│   └── EntityNotFoundException.java
│
├── util/
│   ├── IdGenerator.java
│   └── InputValidator.java
│
└── Main.java

Class diagram

+------------------------------------+
|               Student              |
+------------------------------------+
| - id: String                       |
| - firstName: String                |
| - lastName: String                 |
| - email: String                    |
| - batch: String                    |
| - active: boolean                  |
+------------------------------------+
| + getDisplayName(): String         |
+------------------------------------+
                  ^
                  | (Managed by)
+-----------------+------------------+
|             Course                 |
+------------------------------------+
| - id: String                       |
| - courseName: String               |
| - description: String              |
| - durationInWeeks: int             |
| - active: boolean                  |
+------------------------------------+
                  ^
                  | (Linked via ID)
+-----------------+------------------+
|             Enrollment             |
+------------------------------------+
| - id: String                       |
| - studentId: String                |
| - courseId: String                 |
| - enrollmentDate: LocalDate        |
| - status: EnrollmentStatus         |
+------------------------------------+

        +-----------------------+
        |      IdGenerator      |
        +-----------------------+
        | - studentIdCounter    |
        | - courseIdCounter     |
        | - enrollmentIdCounter |
        +-----------------------+
                 |
                 v
        +-----------------------+
        | Services & UI Layers  |
        | (StudentService, etc) |
        +-----------------------+

Setup & Running Instructions
Prerequisites
JDK 17 or higher installed on your system.

An IDE of your choice (IntelliJ IDEA, Eclipse, or VS Code).

Steps to Run:
1) Clone the repository:
git clone [https://github.com/your-username/learntrack-system.git]
2) Open the project folder in your IDE.
3) Locate the entry point file:
src/main/java/com/airtribe/learntrack/ui/Main.java
4) Run the main method to launch the interactive console menu.


Design Notes
1) Why ArrayList over Arrays? ArrayList was chosen because student, course, and enrollment records grow dynamically at runtime. Standard arrays have a fixed capacity, which would limit data entry.

2) Static Members Usage: Used extensively inside IdGenerator (studentIdCounter, courseIdCounter, enrollmentIdCounter) to maintain a single, shared auto-incrementing sequence across all service instances.

3) Encapsulation: All entity fields are marked private and accessed securely via public getters and setters.