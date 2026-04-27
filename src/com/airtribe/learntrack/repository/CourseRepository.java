package com.airtribe.learntrack.repository;

import java.util.ArrayList;

import com.airtribe.learntrack.entities.Course;

public class CourseRepository {
  static ArrayList<Course> courses = new ArrayList<>();

  static public void addCourse(Course courseDetails) {
    courses.add(courseDetails);
  }

  static public ArrayList<Course> getAllCourse() {
    return courses;
  }
}