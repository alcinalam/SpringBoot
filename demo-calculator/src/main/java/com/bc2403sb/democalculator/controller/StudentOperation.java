package com.bc2403sb.democalculator.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bc2403sb.democalculator.model.Student;

public interface StudentOperation {
  

@GetMapping(value ="/students")
List<Student> getStudents();
 
 
 @GetMapping(value = "/student/add/") // /student/add/?id=1&name=cherry
 List<Student> add(@RequestParam String name, @RequestParam(value="id") int studentId);
  
 
 @GetMapping(value = "student/remove/")// /student/remove/?name=cherry
 List<Student> remove(@RequestParam String name);


@GetMapping(value = "/students/ids")
int [] getAllIds () ;
 
@GetMapping(value = "/students/names")
List<String> getStudentName(@RequestParam(required = false)String name);
}
