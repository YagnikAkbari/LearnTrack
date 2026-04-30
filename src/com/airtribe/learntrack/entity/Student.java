package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.util.IdGenerator;

/**
 * Student class is used for creating a Student with it's identity information
 * which extends Person and have some extra information like status and batch.
 * Student holds information about:
 * 1. batch - to store batch of the Student
 * 2. active - to store status of Student (true or false)
 */
public class Student extends Person {
  int id;
  String batch;
  boolean active;

  public Student(String firstName, String lastName, String email, String batch) {
    super(firstName, lastName, email);
    this.id = IdGenerator.getNextStudentId();
    this.batch = batch;
    this.active = true;
  }

  public int getId() {
    return id;
  }

  public String getBatch() {
    return batch;
  }

  public boolean getStatus() {
    return active;
  }

  public void setStatus(boolean status) {
    this.active = status;
  }

  @Override
  public String getDisplayName() {
    return getFirstName() + " " + getLastName();
  }

  @Override
  public String toString() {
    return "Student{id=" + id
        + ", firstName='" + getFirstName() + '\''
        + ", lastName='" + getLastName() + '\''
        + ", email='" + getEmail() + '\''
        + ", batch='" + batch + '\''
        + ", active=" + active
        + '}';
  }
}
