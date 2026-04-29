package com.airtribe.learntrack.service;

import java.util.ArrayList;

import com.airtribe.learntrack.entities.Course;
import com.airtribe.learntrack.enums.CourseStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.validators.CourseValidator;

public class CourseService {
  private final CourseRepository courseRepository;
  private final CourseValidator courseValidator;

  public CourseService(CourseRepository courseRepository, CourseValidator courseValidator) {
    this.courseRepository = courseRepository;
    this.courseValidator = courseValidator;
  }

  public Course addCourse(Course course) {
    boolean isValidCourse = courseValidator.validateCourse(course);
    if (isValidCourse) {
      courseRepository.addCourse(course);
      return course;
    }
    return null;
  }

  public Course getCourse(int courseId) throws EntityNotFoundException {
    return getCourseOrThrow(courseId);
  }

  public ArrayList<Course> listCourses() {
    return courseRepository.getAllCourse();
  }

  public void activateCourse(int courseId) throws EntityNotFoundException {
    Course c = getCourseOrThrow(courseId);
    c.setStatus(CourseStatus.ACTIVE);
    courseRepository.updateCourse(c);
  }

  public void deactivateCourse(int courseId) throws EntityNotFoundException {
    Course c = getCourseOrThrow(courseId);
    c.setStatus(CourseStatus.INACTIVE);
    courseRepository.updateCourse(c);
  }

  public void removeCourse(int courseId) throws EntityNotFoundException {
    getCourseOrThrow(courseId);
    courseRepository.removeCourse(courseId);
  }

  private Course getCourseOrThrow(int courseId) throws EntityNotFoundException {
    Course c = courseRepository.getCourseById(courseId);
    if (c == null) {
      throw new EntityNotFoundException("Course Not Found!");
    }
    return c;
  }
}