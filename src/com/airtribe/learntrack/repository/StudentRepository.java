package com.airtribe.learntrack.repository;

import java.util.ArrayList;

import com.airtribe.learntrack.entities.Student;

public class StudentRepository {
  static ArrayList<Student> students = new ArrayList<>();

  static public void addStudent(Student details) {
    students.add(details);
  }

  static public Student getStudentById(int studentId) {
    for (Student student : students) {
      if (student.getId() == studentId) {
        return student;
      }
    }
    return null;
  }
}