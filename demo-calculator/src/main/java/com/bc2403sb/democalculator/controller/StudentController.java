package com.bc2403sb.democalculator.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bc2403sb.democalculator.model.Student;




@Controller
@ResponseBody
public class StudentController {
  
  // API: add student (URL -> id name)
  // API: get student List
  // API: remove student by student name
  // API: get all student id -> int []
  // API: get student by name

 @GetMapping(value ="/students")
 public List<Student> getStudents(){
  return Student.studentDB;
 }
 
 @GetMapping(value = "/student/add/") // /student/add/?id=1&name=cherry
  public List<Student> add(@RequestParam String name, @RequestParam(value="id") int studentId) {
    Student.studentDB.add(new Student(studentId, name));
    return Student.studentDB;
  }
 
 @GetMapping(value = "student/remove/")// /student/remove/?name=cherry
 public List<Student> remove(@RequestParam String name) {
    if(name == null)
      return null;  
  List<Student> studentsToBeRemoved = new ArrayList<>();  
  for (Student s : Student.studentDB) {
    if(name.equals(s.getName()))
      studentsToBeRemoved.add(s);
    }
    return Student.studentDB.removeAll(studentsToBeRemoved) ? studentsToBeRemoved : null;
    // Student.class -> equals()
 }


@GetMapping(value = "/students/ids")
 public int [] getAllIds () {
  return Student.studentDB.stream() //
    .mapToInt(e -> e.getIdNumber()) //
    .toArray();

    // if return List<Integer>
    // .map(e-> e.getIdNumber() //
    // .collect(Collectors.toList());
 }
 
@GetMapping(value = "/students/names")
public List<String> getStudentName(){
  if (Student.studentDB == null)
    return null;
  return Student.studentDB.stream()//
    .map(e -> e.getName())//
    .collect(Collectors.toList());
}



}
