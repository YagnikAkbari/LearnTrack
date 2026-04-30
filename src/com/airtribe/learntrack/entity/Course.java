package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.CourseStatus;
import com.airtribe.learntrack.util.IdGenerator;

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
  private int id;
  private String courseName;
  private String description;
  private int durationInWeeks;
  private CourseStatus active;

  public Course(String courseName, String description, int durationInWeeks) {
    this.id = IdGenerator.getNextCourseId();
    this.courseName = courseName;
    this.description = description;
    this.durationInWeeks = durationInWeeks;
    this.active = CourseStatus.ACTIVE;
  }

  public int getId() {
    return id;
  }

  public String getCourseName() {
    return courseName;
  }

  public String getDescription() {
    return description;
  }

  public int getDurationInWeeks() {
    return durationInWeeks;
  }

  public CourseStatus getStatus() {
    return active;
  }

  public void setStatus(CourseStatus status) {
    this.active = status;
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
