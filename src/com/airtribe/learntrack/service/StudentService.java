package com.airtribe.learntrack.service;

import java.util.ArrayList;

import com.airtribe.learntrack.entities.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.validators.StudentValidator;

public class StudentService {

  private final StudentRepository studentRepository;
  private final StudentValidator studentValidator;

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
      studentRepository.updateStudent(student);
      return student;
    }
    return null;
  }

  public Student getStudent(int studentId) throws EntityNotFoundException {
    return getStudentOrThrow(studentId);
  }

  public void removeStudent(int studentId) throws EntityNotFoundException {
    getStudentOrThrow(studentId);
    studentRepository.removeStudent(studentId);
  }

  public void changeStatus(int studentId, boolean status) throws EntityNotFoundException {
    Student s = getStudentOrThrow(studentId);
    s.setStatus(status);
    updateStudent(s);
  }

  public ArrayList<Student> listStudents() {
    return studentRepository.getAllStudents();
  }

  private Student getStudentOrThrow(int studentId) throws EntityNotFoundException {
    Student s = studentRepository.getStudentById(studentId);
    if (s == null) {
      throw new EntityNotFoundException("Student Not Found!");
    }
    return s;
  }
}