package rw.ac.unilak.MIS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.ac.unilak.MIS.entity.Course;
import rw.ac.unilak.MIS.repository.CourseRepository;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
  @Autowired
  public CourseRepository courseRepository;
  /**
   * @param course
   * @return
   */
  @Override
  public Course createCourse(Course course) {
    return courseRepository.save(course);
  }

  /**
   * @param id
   * @return
   */
  @Override
  public Course getCourseById(int id) {
    return courseRepository.findById(id).orElse(null);
  }

  /**
   * @return
   */
  @Override
  public List<Course> getAllCourses() {
    return courseRepository.findAll();
  }

  /**
   * @param id
   */
  @Override
  public void deleteCourseById(int id) {
    courseRepository.deleteById(id);
  }
}
