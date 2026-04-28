package com.airtribe.learntrack;

import com.airtribe.learntrack.entities.Course;
import com.airtribe.learntrack.entities.Enrollment;
import com.airtribe.learntrack.entities.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.StudentService;

public class Main {
  public static void main(String[] args) {
    Course c1 = new Course("Learn AI with Python", "You will be shocked by learning this course.", 3);
    Course c2 = new Course("Learn with Yagnik", "You will be shocked by him personality.", 7);
    Course c3 = new Course("Learn in universe", "You will be shocked by going to universe.", 69);
    CourseRepository.addCourse(c1);
    CourseRepository.addCourse(c2);
    CourseRepository.addCourse(c3);
    for (Course course : CourseRepository.getAllCourse()) {
      System.out.println(course);
    }
    Student s1 = new Student("Yagnik", "Akbari", "", "bc-java-20");
    Student s2 = new Student("", "Akbari", "kishan.offical@gmail.com", "bc-java-20");
    Student s3 = new Student("Raj", "Akbari", "raj.akbari.97@gmail.com", "bc-java-21");

    // s1 — has empty email, so addStudent will reject it
    try {
      StudentService.addStudent(s1);
      System.out.println(s1);
    } catch (Exception err) {
      System.out.println("Failed to add student s1: " + err.getMessage());
    }
    try {
      StudentService.changeStatus(s1.getId(), false);
    } catch (Exception err) {
      if (err instanceof EntityNotFoundException) {
        System.out.println("EntityNotFoundException:" + err.getMessage());
      } else {
        System.out.println("Failure while change Status:" + err.getMessage());
      }
    }

    // s2 and s3 — valid students
    try {
      StudentService.addStudent(s2);
    } catch (Exception err) {
      System.out.println("Failed to add student s2: " + err.getMessage());
    }
    try {
      StudentService.addStudent(s3);
    } catch (Exception err) {
      System.out.println("Failed to add student s3: " + err.getMessage());
    }

    // Only enroll students that were successfully added
    Enrollment e1 = new Enrollment(s2.getId(), c1.getId());
    Enrollment e2 = new Enrollment(s2.getId(), c3.getId());
    Enrollment e3 = new Enrollment(s3.getId(), c3.getId());
    EnrollmentRepository.addEnrollment(e1);
    EnrollmentRepository.addEnrollment(e2);
    EnrollmentRepository.addEnrollment(e3);
    for (Enrollment enrollment : EnrollmentRepository.getAllEnrollments()) {
      System.out.println(enrollment);
    }
  }
}
