package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entities.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.validators.StudentValidator;

public class StudentService {

  private StudentRepository studentRepository;
  private StudentValidator studentValidator;

  public StudentService(StudentRepository studentRepository, StudentValidator studentValidator) {
    this.studentRepository = studentRepository;
    this.studentValidator = studentValidator;
  }

  public Student addStudent(Student student) {
    boolean isValidStudent = studentValidator.validateStudent(student);
    if (isValidStudent) {
      studentRepository.addStudent(student);
      return student;
    }
    return null;
  }

  public Student updateStudent(Student student) {
    boolean isValidStudent = studentValidator.validateStudent(student);
    if (isValidStudent) {
      studentRepository.updateStudent(student.getId(), student);
      return student;
    }
    return null;
  }

  public Student getStudent(int studenId) {
    return studentRepository.getStudentById(studenId);
  }

  public void removeStudent(int studenId) {
    studentRepository.removeStudent(studenId);
  }

  public void changeStatus(int studentId, boolean status) throws EntityNotFoundException {
    Student s = studentRepository.getStudentById(studentId);
    if (s == null) {
      throw new EntityNotFoundException("Student Not Found!");
    }
    s.setStatus(status);
    updateStudent(s);
  }

  public void listStudents() {
    for (Student student : studentRepository.getAllStudents()) {
      System.out.println(student);
    }
  }
}