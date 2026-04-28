package com.airtribe.learntrack.service;

import com.airtribe.learntrack.repository.CourseRepository;

public class CourseService {
  private final CourseRepository courseRepository;

  public CourseService(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }
}