package rw.ac.unilak.MIS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.unilak.MIS.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
