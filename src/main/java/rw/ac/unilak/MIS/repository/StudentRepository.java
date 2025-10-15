package rw.ac.unilak.MIS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.unilak.MIS.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
