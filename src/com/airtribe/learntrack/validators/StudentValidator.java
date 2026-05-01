package com.airtribe.learntrack.validators;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.util.InputValidator;

public class StudentValidator {
  public void validateStudent(Student student) throws InvalidInputException {
    if (student.getLastName() == null || student.getLastName().isEmpty()) {
      throw new InvalidInputException("LastName is required");
    }
    if (!InputValidator.validateString(student.getLastName(), 1, 255)) {
      throw new InvalidInputException("Please Enter Valid LastName (min character 1 - max character 255)");
    }
    if (student.getFirstName() == null || student.getFirstName().isEmpty()) {
      throw new InvalidInputException("FirstName is required");
    }
    if (!InputValidator.validateString(student.getFirstName(), 1, 255)) {
      throw new InvalidInputException("Please Enter Valid FirstName (min character 1 - max character 255)");
    }
    if (student.getEmail() == null || student.getEmail().isEmpty()) {
      throw new InvalidInputException("Email is required");
    }
    if (!InputValidator.validateEmail(student.getEmail())) {
      throw new InvalidInputException("Please Enter Valid Email.(eg. john.doe@gmail.com)");
    }
  }
}
