package com.airtribe.learntrack.entities;

import com.airtribe.learntrack.enums.CourseStatus;

/**
 * Course class is used for create Course in which Student can enroll
 * Course holds information about:
 * 1. id - unique id for each Course
 * 2. courseName - to store Course's name
 * 3. description - to store Coruse's description
 * 4. durationInWeeks - hold Course's total learning week
 * 5. active - holds status of the course (eg. ACTIVE, INACTIVE)
 */
public class Course {
  static int courseIdCounter = 0;
  private int id;
  private String courseName;
  private String description;
  private int durationInWeeks;
  private CourseStatus active;

  public Course(String courseName, String description, int durationInWeeks) {
    this.id = getNextCourseId();
    this.courseName = courseName;
    this.description = description;
    this.durationInWeeks = durationInWeeks;
    this.active = CourseStatus.ACTIVE;
  }

  private int getNextCourseId() {
    return ++courseIdCounter;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Course{id=" + id
        + ", courseName='" + courseName + '\''
        + ", description='" + description + '\''
        + ", durationInWeeks=" + durationInWeeks
        + ", active=" + active
        + '}';
  }
}
