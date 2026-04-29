package com.airtribe.learntrack.validators;

import com.airtribe.learntrack.entities.Enrollment;

public class EnrollmentValidator {
  public boolean validateEnrollment(Enrollment enrollment) {
    if (enrollment.getStudentId() <= 0) {
      throw new IllegalArgumentException("Valid Student ID is required");
    }
    if (enrollment.getCourseId() <= 0) {
      throw new IllegalArgumentException("Valid Course ID is required");
    }
    return true;
  }
}
