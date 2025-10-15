package rw.ac.unilak.MIS.service;

import rw.ac.unilak.MIS.entity.Course;

import java.util.List;

public interface CourseService {
  Course createCourse(Course course);
  Course getCourseById(int id);
  List<Course> getAllCourses();
  void deleteCourseById(int id);
}
