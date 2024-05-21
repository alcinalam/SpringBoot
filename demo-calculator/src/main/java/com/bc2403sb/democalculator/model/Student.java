package com.bc2403sb.democalculator.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends Person{

  public final static List<Student>studentDB = new LinkedList<>();
  private String name;

  public Student (int studentID, String name) {
    super(studentID);
    this.name = name;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
    return true;
    if(!(obj instanceof Student))
    return false;
    Student student = (Student) obj;
    return Objects.equals(this.getIdNumber(), student.getIdNumber());
  }

  @Override
  public int hashCode (){
    return Objects.hash(this.getIdNumber());
  }
  
}
