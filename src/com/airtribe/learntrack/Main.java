package com.airtribe.learntrack;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.validators.CourseValidator;
import com.airtribe.learntrack.validators.EnrollmentValidator;
import com.airtribe.learntrack.validators.StudentValidator;

public class Main {
  public static void main(String[] args) {
    // ======================== Setup ========================
    StudentRepository studentRepository = new StudentRepository();
    StudentValidator studentValidator = new StudentValidator();
    StudentService studentService = new StudentService(studentRepository, studentValidator);

    CourseRepository courseRepository = new CourseRepository();
    CourseValidator courseValidator = new CourseValidator();
    CourseService courseService = new CourseService(courseRepository, courseValidator);

    EnrollmentRepository enrollmentRepository = new EnrollmentRepository();
    EnrollmentValidator enrollmentValidator = new EnrollmentValidator();
    EnrollmentService enrollmentService = new EnrollmentService(enrollmentRepository, enrollmentValidator);

    // ======================== Student Management ========================
    System.out.println("========== STUDENT MANAGEMENT ==========");

    Student s1 = new Student("Yagnik", "Akbari", "yagnik@gmail.com", "bc-java-20");
    Student s2 = new Student("Kishan", "Akbari", "kishan.offical@gmail.com", "bc-java-20");
    Student s3 = new Student("Raj", "Akbari", "raj.akbari.97@gmail.com", "bc-java-21");

    // Add Students
    try {
      studentService.addStudent(s1);
      System.out.println("Added: " + s1);
    } catch (Exception err) {
      System.out.println("Failed to add student s1: " + err.getMessage());
    }

    try {
      studentService.addStudent(s2);
      System.out.println("Added: " + s2);
    } catch (Exception err) {
      System.out.println("Failed to add student s2: " + err.getMessage());
    }

    try {
      studentService.addStudent(s3);
      System.out.println("Added: " + s3);
    } catch (Exception err) {
      System.out.println("Failed to add student s3: " + err.getMessage());
    }

    // View Students
    System.out.println("\n--- All Students ---");
    System.out.println(studentService.listStudents());

    // Change Status (Deactivate)
    try {
      studentService.changeStatus(s1.getId(), false);
      System.out.println("Deactivated student s1");
    } catch (Exception err) {
      if (err instanceof EntityNotFoundException) {
        System.out.println("EntityNotFoundException:" + err.getMessage());
      } else {
        System.out.println("Failure while change Status:" + err.getMessage());
      }
    }

    // Remove Student
    try {
      studentService.removeStudent(s2.getId());
      System.out.println("Removed student s2");
    } catch (Exception err) {
      System.out.println("Failed to remove student s2: " + err.getMessage());
    }

    System.out.println("\n--- Students after changes ---");
    System.out.println(studentService.listStudents());

    // ======================== Course Management ========================
    System.out.println("\n========== COURSE MANAGEMENT ==========");

    // Add Courses
    Course c1 = new Course("Learn AI with Python", "You will be shocked by learning this course.", 3);
    Course c2 = new Course("Learn with Yagnik", "You will be shocked by him personality.", 7);
    Course c3 = new Course("Learn in universe", "You will be shocked by going to universe.", 69);

    try {
      courseService.addCourse(c1);
      System.out.println("Added: " + c1);
    } catch (Exception err) {
      System.out.println("Failed to add course c1: " + err.getMessage());
    }

    try {
      courseService.addCourse(c2);
      System.out.println("Added: " + c2);
    } catch (Exception err) {
      System.out.println("Failed to add course c2: " + err.getMessage());
    }

    try {
      courseService.addCourse(c3);
      System.out.println("Added: " + c3);
    } catch (Exception err) {
      System.out.println("Failed to add course c3: " + err.getMessage());
    }

    // View Courses
    System.out.println("\n--- All Courses ---");
    for (Course course : courseService.listCourses()) {
      System.out.println(course);
    }

    // Deactivate Course
    try {
      courseService.deactivateCourse(c2.getId());
      System.out.println("\nDeactivated course c2 (id=" + c2.getId() + ")");
    } catch (EntityNotFoundException err) {
      System.out.println("EntityNotFoundException: " + err.getMessage());
    }

    // Activate Course back
    try {
      courseService.activateCourse(c2.getId());
      System.out.println("Activated course c2 back (id=" + c2.getId() + ")");
    } catch (EntityNotFoundException err) {
      System.out.println("EntityNotFoundException: " + err.getMessage());
    }

    // Try deactivating a non-existent course
    try {
      courseService.deactivateCourse(999);
    } catch (EntityNotFoundException err) {
      System.out.println("EntityNotFoundException: " + err.getMessage());
    }

    System.out.println("\n--- Courses after changes ---");
    for (Course course : courseService.listCourses()) {
      System.out.println(course);
    }

    // ======================== Enrollment Management ========================
    System.out.println("\n========== ENROLLMENT MANAGEMENT ==========");

    // Enroll Students
    Enrollment e1 = new Enrollment(s1.getId(), c1.getId());
    Enrollment e2 = new Enrollment(s1.getId(), c3.getId());
    Enrollment e3 = new Enrollment(s3.getId(), c3.getId());

    try {
      enrollmentService.enrollStudent(e1);
      System.out.println("Enrolled: " + e1);
    } catch (Exception err) {
      System.out.println("Failed to enroll e1: " + err.getMessage());
    }

    try {
      enrollmentService.enrollStudent(e2);
      System.out.println("Enrolled: " + e2);
    } catch (Exception err) {
      System.out.println("Failed to enroll e2: " + err.getMessage());
    }

    try {
      enrollmentService.enrollStudent(e3);
      System.out.println("Enrolled: " + e3);
    } catch (Exception err) {
      System.out.println("Failed to enroll e3: " + err.getMessage());
    }

    // View Enrollments
    System.out.println("\n--- All Enrollments ---");
    for (Enrollment enrollment : enrollmentService.listEnrollments()) {
      System.out.println(enrollment);
    }

    // Mark Enrollment as Completed
    try {
      enrollmentService.markAsCompleted(e1.getId());
      System.out.println("\nMarked enrollment e1 (id=" + e1.getId() + ") as COMPLETED");
    } catch (EntityNotFoundException err) {
      System.out.println("EntityNotFoundException: " + err.getMessage());
    }

    // Mark Enrollment as Cancelled
    try {
      enrollmentService.markAsCancelled(e2.getId());
      System.out.println("Marked enrollment e2 (id=" + e2.getId() + ") as CANCELLED");
    } catch (EntityNotFoundException err) {
      System.out.println("EntityNotFoundException: " + err.getMessage());
    }

    // Update Status using generic method
    try {
      enrollmentService.updateStatus(e3.getId(), EnrollmentStatus.COMPLETED);
      System.out.println("Updated enrollment e3 (id=" + e3.getId() + ") status to COMPLETED");
    } catch (EntityNotFoundException err) {
      System.out.println("EntityNotFoundException: " + err.getMessage());
    }

    // Try updating a non-existent enrollment
    try {
      enrollmentService.markAsCompleted(999);
    } catch (EntityNotFoundException err) {
      System.out.println("EntityNotFoundException: " + err.getMessage());
    }

    System.out.println("\n--- Enrollments after status changes ---");
    for (Enrollment enrollment : enrollmentService.listEnrollments()) {
      System.out.println(enrollment);
    }
  }
}
