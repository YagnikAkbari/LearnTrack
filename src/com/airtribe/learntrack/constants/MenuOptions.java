package com.airtribe.learntrack.constants;

public class MenuOptions {
  static final String menu = """
      ===== LearnTrack Menu =====
      1. Student Management
      2. Course Management
      3. Enrollment Management
      4. Exit
      """;
  static final String studentOptions = """
      ----- Student Management -----
      1. Add Student
      2. View All Students
      3. Search by ID
      4. Deactivate Student
      5. Back
      """;
  static final String courseOptions = """
      ----- Course Management -----
      1. Add Course
      2. View Courses
      3. Activate/Deactivate Course
      4. Back
      """;
  static final String enrollmentOptions = """
      ----- Enrollment Management -----
      1. Enroll Student
      2. View Enrollments
      3. Update Status (Completed/Cancelled)
      4. Back
      """;
}