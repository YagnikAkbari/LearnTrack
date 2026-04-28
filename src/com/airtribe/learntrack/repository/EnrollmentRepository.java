package com.airtribe.learntrack.repository;

import java.util.ArrayList;
import com.airtribe.learntrack.entities.Enrollment;

public class EnrollmentRepository {
  private final ArrayList<Enrollment> enrollments = new ArrayList<>();

  public void addEnrollment(Enrollment details) {
    enrollments.add(details);
  }

  public ArrayList<Enrollment> getAllEnrollments() {
    return enrollments;
  }
}