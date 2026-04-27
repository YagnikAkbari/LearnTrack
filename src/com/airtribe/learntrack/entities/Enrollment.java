package com.airtribe.learntrack.entities;

/**
 * import statement is used when you want to access class from different package (for same package java resolve it automatically).
 */

import com.airtribe.learntrack.enums.EnrollmentStatus;

/**
 * Enrollment class is used for create Enrollment of Students into one or more
 * Courses
 * Enrollment holds information about:
 * 1. id - unique id for each entrollment
 * 2. studenId - to store Student's id who is entrolled in
 * 3. courseId - to store coruse's id Student entrolled in
 * 4. enrollmentDate - hold student enrolled in the course on which date
 * 5. status - holds status of the student enrollment in course (eg. ACTIVE,
 * COMPLETED, CANCELLED)
 */
public class Enrollment {
  private int id;
  private String studentId;
  private int courseId;
  private String enrollmentDate;
  private EnrollmentStatus status;
}
