package com.airtribe.learntrack.entities;

/**
 * Person class is used for creating a Person with it's identity information
 * Person holds information about:
 * 1. id - unique id for each entrollment
 * 2. firstName - to store Person's firstName
 * 3. lastName - to store Person's lastName
 * 4. email - to store Person's email
 */
public class Person {
  private int id;
  private String firstName;
  private String lastName;
  private String email;

  Person(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }
}
