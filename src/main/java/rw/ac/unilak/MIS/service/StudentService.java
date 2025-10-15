package rw.ac.unilak.MIS.service;

import rw.ac.unilak.MIS.entity.Student;

import java.util.List;

public interface StudentService {
  Student createStudent(Student student);
  Student getStudentById(int id);
  List<Student> getAllStudents();
  void deleteStudentById(int id);
}
