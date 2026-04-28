package com.airtribe.learntrack.repository;

import java.util.ArrayList;

import com.airtribe.learntrack.entities.Course;

public class CourseRepository {
  private final ArrayList<Course> courses = new ArrayList<>();

  public void addCourse(Course courseDetails) {
    courses.add(courseDetails);
  }

  public Course getCourseById(int courseId) {
    return courses.get(0);
  }

  public ArrayList<Course> getAllCourse() {
    return courses;
  }
}