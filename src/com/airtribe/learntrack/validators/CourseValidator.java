package com.airtribe.learntrack.validators;

import com.airtribe.learntrack.entities.Course;
import com.airtribe.learntrack.utils.InputValidator;

public class CourseValidator {
  public boolean validateCourse(Course course) {
    if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
      throw new IllegalArgumentException("Course Name is required");
    }
    if (!InputValidator.validateString(course.getCourseName(), 1, 255)) {
      throw new IllegalArgumentException("Please Enter Valid Course Name (min character 1 - max character 255)");
    }
    if (course.getDescription() == null || course.getDescription().isEmpty()) {
      throw new IllegalArgumentException("Description is required");
    }
    if (!InputValidator.validateString(course.getDescription(), 1, 1000)) {
      throw new IllegalArgumentException("Please Enter Valid Description (min character 1 - max character 1000)");
    }
    if (course.getDurationInWeeks() <= 0) {
      throw new IllegalArgumentException("Duration in weeks must be greater than 0");
    }
    return true;
  }
}
