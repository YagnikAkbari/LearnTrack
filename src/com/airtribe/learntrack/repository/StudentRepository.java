package com.airtribe.learntrack.repository;

import java.util.ArrayList;

import com.airtribe.learntrack.entities.Student;

public class StudentRepository {
  private ArrayList<Student> students = new ArrayList<>();

  public void addStudent(Student details) {
    students.add(details);
  }

  public void updateStudent(int studentId, Student details) {
    int index = getStudentIndexById(studentId);
    if (index >= 0) {
      students.set(index, details);
    }
  }

  private int getStudentIndexById(int studentId) {
    for (int i = 0; i < students.size(); i++) {
      if (students.get(i).getId() == studentId) {
        return i;
      }
    }
    return -1;
  }

  public Student getStudentById(int studentId) {
    for (Student student : students) {
      if (student.getId() == studentId) {
        return student;
      }
    }
    return null;
  }

  public ArrayList<Student> getAllStudents() {
    return students;
  }

  public void removeStudent(int studentId) {
    int index = getStudentIndexById(studentId);
    if (index >= 0) {
      students.remove(index);
    }
  }
}