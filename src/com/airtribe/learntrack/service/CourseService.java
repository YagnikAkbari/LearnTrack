package com.airtribe.learntrack.service;

import com.airtribe.learntrack.repository.CourseRepository;

public class CourseService {
  private CourseRepository courseRepository;

  public CourseService(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }
}