package edu.miu.cs.cs544.ether.service;

import java.util.List;
import java.util.function.Predicate;

import edu.miu.cs.cs544.ether.dal.entity.Student;

public interface StudentService {
   public  Student getStudent(Predicate<Student> predicate) throws Exception;
   public  Student getStudent(Long Id) throws Exception;
   List<Student> getStudents() throws Exception;
}
