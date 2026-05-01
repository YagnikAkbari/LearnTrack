package com.airtribe.learntrack.service;

import java.util.ArrayList;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.validators.EnrollmentValidator;

public class EnrollmentService {
  private final EnrollmentRepository enrollmentRepository;
  private final EnrollmentValidator enrollmentValidator;

  public EnrollmentService(EnrollmentRepository enrollmentRepository, EnrollmentValidator enrollmentValidator) {
    this.enrollmentRepository = enrollmentRepository;
    this.enrollmentValidator = enrollmentValidator;
  }

  public Enrollment enrollStudent(Enrollment enrollment) throws InvalidInputException {
    enrollmentValidator.validateEnrollment(enrollment);
    enrollmentRepository.addEnrollment(enrollment);
    return enrollment;
  }

  public Enrollment getEnrollment(int enrollmentId) throws EntityNotFoundException {
    return getEnrollmentOrThrow(enrollmentId);
  }

  public ArrayList<Enrollment> listEnrollments() {
    return enrollmentRepository.getAllEnrollments();
  }

  public void markAsCompleted(int enrollmentId) throws EntityNotFoundException {
    Enrollment e = getEnrollmentOrThrow(enrollmentId);
    e.setStatus(EnrollmentStatus.COMPLETED);
    enrollmentRepository.updateEnrollment(e);
  }

  public void markAsCancelled(int enrollmentId) throws EntityNotFoundException {
    Enrollment e = getEnrollmentOrThrow(enrollmentId);
    e.setStatus(EnrollmentStatus.CANCELLED);
    enrollmentRepository.updateEnrollment(e);
  }

  public void updateStatus(int enrollmentId, EnrollmentStatus status) throws EntityNotFoundException {
    Enrollment e = getEnrollmentOrThrow(enrollmentId);
    e.setStatus(status);
    enrollmentRepository.updateEnrollment(e);
  }

  public void removeEnrollment(int enrollmentId) throws EntityNotFoundException {
    getEnrollmentOrThrow(enrollmentId);
    enrollmentRepository.removeEnrollment(enrollmentId);
  }

  private Enrollment getEnrollmentOrThrow(int enrollmentId) throws EntityNotFoundException {
    Enrollment e = enrollmentRepository.getEnrollmentById(enrollmentId);
    if (e == null) {
      throw new EntityNotFoundException("Enrollment Not Found!");
    }
    return e;
  }
}