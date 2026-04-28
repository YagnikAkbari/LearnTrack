package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entities.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.validators.StudentValidator;

public class StudentService {

  public static void addStudent(Student student) {
    boolean isValidStudent = StudentValidator.validate(student);
    if (isValidStudent) {
      StudentRepository.addStudent(student);
    }
  }

  public static Student updateStudent(Student student) {
    return student;
  }

  public static void removeStudent(int id) {

  }

  public static void changeStatus(int studentId, boolean status) throws EntityNotFoundException {
    Student s = StudentRepository.getStudentById(studentId);
    if (s == null) {
      throw new EntityNotFoundException("Student Not Found!");
    }
    System.out.println("Change Status to => " + status + " for " + s.toString());
    s.setStatus(status);
  }

  public static void listStudents() {

  }
}