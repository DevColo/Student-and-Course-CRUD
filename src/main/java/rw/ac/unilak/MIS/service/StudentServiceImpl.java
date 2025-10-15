package rw.ac.unilak.MIS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.ac.unilak.MIS.entity.Student;
import rw.ac.unilak.MIS.repository.StudentRepository;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{
    /**
     * @param student
     * @return
     */
    @Autowired
    public StudentRepository studentRepository;
  @Override
  public Student createStudent(Student student) {
    return studentRepository.save(student);
  }

    /**
     * @param id
     * @return
     */
  @Override
  public Student getStudentById(int id) {
    return studentRepository.findById(id).orElse(null);
  }

    /**
     * @return
     */
  @Override
  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

    /**
     * @param id
     */
  @Override
  public void deleteStudentById(int id) {
    studentRepository.deleteById(id);
  }
}
