package com.airtribe.learntrack.service;

import com.airtribe.learntrack.repository.EnrollmentRepository;

public class EnrollmentService {
  private final EnrollmentRepository enrollmentRepository;

  public EnrollmentService(EnrollmentRepository enrollmentRepository) {
    this.enrollmentRepository = enrollmentRepository;
  }
}