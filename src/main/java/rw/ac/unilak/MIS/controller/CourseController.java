package rw.ac.unilak.MIS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.ac.unilak.MIS.entity.Course;
import rw.ac.unilak.MIS.service.CourseService;

@RequestMapping("/course")
@RestController
public class CourseController {
  @Autowired
  public CourseService courseService;

  // Method to create Course
  @PostMapping("create")
  public ResponseEntity<?> createCourse(@RequestBody Course course){
    // check unique Course
    try{
      Course newCourse = courseService.createCourse(course);
      if (newCourse != null){
        return ResponseEntity.ok(newCourse);
      }else {
        return ResponseEntity.badRequest().body("An error occured");
      }
    } catch (DataIntegrityViolationException e) {
      return ResponseEntity.badRequest().body("The course already exists");
    }
  }

  // Method to get all Courses
  @GetMapping("find-all")
  public ResponseEntity<?> getAllCourses(){
    if (courseService.getAllCourses() != null){
      return ResponseEntity.ok(courseService.getAllCourses());
    }else {
      return ResponseEntity.badRequest().body("An error occured");
    }
  }

  // Method to update Course by id
  @PutMapping("update/{courseId}")
  public ResponseEntity<?> updateCourse(@PathVariable int courseId, @RequestBody Course course){
    Course currentCourse = courseService.getCourseById(courseId);
    if (currentCourse == null){
      return ResponseEntity.badRequest().body("Course not found");
    }
    currentCourse.setTitle(course.getTitle());
    currentCourse.setCredits(course.getCredits());
    Course updatedCourse = courseService.createCourse(currentCourse);
    if(updatedCourse != null){
      return ResponseEntity.ok(updatedCourse);
    }else {
      return ResponseEntity.badRequest().body("An error occured");
    }
  }

  // Method to delete Course by id
  @DeleteMapping("delete/{courseId}")
  public ResponseEntity<?> deleteCourse(@PathVariable int courseId){
    Course currentCourse = courseService.getCourseById(courseId);
    if (currentCourse == null){
      return ResponseEntity.badRequest().body("Course not found");
    }
    courseService.deleteCourseById(courseId);
    return ResponseEntity.ok("Course deleted successfully.");
  }
}
