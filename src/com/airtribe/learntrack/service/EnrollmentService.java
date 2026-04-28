package com.airtribe.learntrack.service;

import com.airtribe.learntrack.repository.EnrollmentRepository;

public class EnrollmentService {
  private EnrollmentRepository enrollmentRepository;

  public EnrollmentService(EnrollmentRepository enrollmentRepository) {
    this.enrollmentRepository = enrollmentRepository;
  }
}