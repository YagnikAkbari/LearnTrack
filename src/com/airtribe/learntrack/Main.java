package com.airtribe.learntrack;

import com.airtribe.learntrack.entities.Course;
import com.airtribe.learntrack.entities.Enrollment;
import com.airtribe.learntrack.entities.Student;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;

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
    Student s1 = new Student("Yagnik", "Akbari", "yagnik58ppsv@gmail.com", "bc-java-20");
    Student s2 = new Student("Kisha", "Akbari", "kishan.offical@gmail.com", "bc-java-20");
    Student s3 = new Student("Raj", "Akbari", "raj.akbari.97@gmail.com", "bc-java-21");
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);

    Enrollment e1 = new Enrollment(s1.getId(), c1.getId());
    Enrollment e2 = new Enrollment(s1.getId(), c3.getId());
    Enrollment e3 = new Enrollment(s2.getId(), c3.getId());
    EnrollmentRepository.addEnrollment(e1);
    EnrollmentRepository.addEnrollment(e2);
    EnrollmentRepository.addEnrollment(e3);
    for (Enrollment enrollment : EnrollmentRepository.getAllEnrollments()) {
      System.out.println(enrollment);
    }
  }
}
