package com.airtribe.learntrack.repository;

import java.util.ArrayList;
import com.airtribe.learntrack.entities.Enrollment;

public class EnrollmentRepository {
  static ArrayList<Enrollment> enrollments = new ArrayList<>();

  static public void addEnrollment(Enrollment details) {
    enrollments.add(details);
  }

  static public ArrayList<Enrollment> getAllEnrollments() {
    return enrollments;
  }
}