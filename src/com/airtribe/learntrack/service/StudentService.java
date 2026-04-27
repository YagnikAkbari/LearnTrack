package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entities.Student;
import com.airtribe.learntrack.repository.StudentRepository;

public class StudentService {

  public static void addStudent(Student student) {

  }

  public static Student updateStudent(Student student) {
    return student;
  }

  public static void removeStudent(int id) {

  }

  public static void changeStatus(int studentId, boolean status) {
    Student s = StudentRepository.getStudentById(studentId);
    System.out.println("Change Status to => " + status + " for " + s.toString());
    s.setStatus(status);
    // updateStudent(s);
  }

  public static void listStudents() {

  }
}