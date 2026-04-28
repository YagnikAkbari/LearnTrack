package com.airtribe.learntrack.validators;

import com.airtribe.learntrack.entities.Student;
import com.airtribe.learntrack.utils.InputValidator;

public class StudentValidator {
  public boolean validateStudent(Student student) {
    if (student.getLastName() == null || student.getLastName().isEmpty()) {
      throw new IllegalArgumentException("LastName is required");
    }
    if (!InputValidator.validateString(student.getLastName(), 1, 255)) {
      throw new IllegalArgumentException("Please Enter Valid LastName (min character 1 - max character 255)");
    }
    if (student.getFirstName() == null || student.getFirstName().isEmpty()) {
      throw new IllegalArgumentException("FirstName is required");
    }
    if (!InputValidator.validateString(student.getFirstName(), 1, 255)) {
      throw new IllegalArgumentException("Please Enter Valid FirstName (min character 1 - max character 255)");
    }
    if (student.getEmail() == null || student.getEmail().isEmpty()) {
      throw new IllegalArgumentException("Email is required");
    }
    if (!InputValidator.validateEmail(student.getEmail())) {
      throw new IllegalArgumentException("Please Enter Valid Email.(eg. john.doe@gmail.com)");
    }
    return true;
  }
}
