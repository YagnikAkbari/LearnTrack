package com.airtribe.learntrack.entities;

public class Trainer extends Person {
  double weeklyCost;
  boolean status;

  public Trainer(String firstName, String lastName, String email, double weeklyCost) {
    super(firstName, lastName, email);
    this.weeklyCost = weeklyCost;
    this.status = true;
  }
}
