package rw.ac.unilak.MIS.controller;

import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rw.ac.unilak.MIS.entity.Student;
import rw.ac.unilak.MIS.service.StudentService;

@RequestMapping("/student")
@RestController
public class StudentController {
  @Autowired
  public StudentService studentService;

  // Method to create Student
  @PostMapping("create")
  public ResponseEntity<?> createStudent(@RequestBody Student student){
    // check unique Student
    try{
      Student newStudent = studentService.createStudent(student);
      if (newStudent != null){
        return ResponseEntity.ok(newStudent);
      }else {
        return ResponseEntity.badRequest().body("An error occured");
      }
    } catch (DataIntegrityViolationException e) {
      return ResponseEntity.badRequest().body("The student already exists");
    }
  }

  // Method to get all Students
  @GetMapping("find-all")
  public ResponseEntity<?> getAllStudents(){
    if (studentService.getAllStudents() != null){
      return ResponseEntity.ok(studentService.getAllStudents());
    }else {
      return ResponseEntity.badRequest().body("An error occured");
    }
  }

  // Method to update Student by id
  @PutMapping("update/{studentId}")
  public ResponseEntity<?> updateStudent(@PathVariable int studentId, @RequestBody Student student){
    Student currentStudent = studentService.getStudentById(studentId);
    if (currentStudent == null){
      return ResponseEntity.badRequest().body("Student not found");
    }
    currentStudent.setFirstName(student.getFirstName());
    currentStudent.setLastName(student.getLastName());
    currentStudent.setEmail(student.getEmail());
    currentStudent.setPhoneNumber(student.getPhoneNumber());
    Student updatedStudent = studentService.createStudent(currentStudent);
    if(updatedStudent != null){
      return ResponseEntity.ok(updatedStudent);
    }else {
      return ResponseEntity.badRequest().body("An error occured");
    }
  }

  // Method to delete Student by id
  @DeleteMapping("delete/{studentId}")
  public ResponseEntity<?> deleteStudent(@PathVariable int studentId){
    Student currentStudent = studentService.getStudentById(studentId);
    if (currentStudent == null){
      return ResponseEntity.badRequest().body("Student not found");
    }
    studentService.deleteStudentById(studentId);
    return ResponseEntity.ok("Student deleted successfully.");
  }
}
