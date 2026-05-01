package com.airtribe.learntrack.validators;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.exception.InvalidInputException;

public class EnrollmentValidator {
  public void validateEnrollment(Enrollment enrollment) throws InvalidInputException {
    if (enrollment.getStudentId() <= 0) {
      throw new InvalidInputException("Valid Student ID is required");
    }
    if (enrollment.getCourseId() <= 0) {
      throw new InvalidInputException("Valid Course ID is required");
    }
  }
}
