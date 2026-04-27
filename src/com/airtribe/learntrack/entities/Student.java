package com.airtribe.learntrack.entities;

/**
 * Student class is used for creating a Student with it's identity information
 * which extends Person and have some extra information like status and batch.
 * Student holds information about:
 * 1. batch - to store batch of the Student
 * 2. active - to store status of Student (true or false)
 */
public class Student extends Person {
  static int studentIdCounter;
  String batch;
  boolean active;

  public Student(String firstName, String lastName, String email, String batch) {
    super(firstName, lastName, email);
    this.batch = batch;
    this.active = true;
  }

  int getNextStudentId() {
    return studentIdCounter + 1;
  }
}
