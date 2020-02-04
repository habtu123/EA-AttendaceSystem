package edu.miu.cs.cs544.ether.service;

import edu.miu.cs.cs544.ether.dal.entitiy.Student;

import java.util.List;
import java.util.function.Predicate;

public interface StudentService {
   public  List<Student> listOfStudent() throws Exception;
   public  Student getStudent(Predicate<Student> predicate) throws Exception;
   public  Student getStudent(Long Id) throws Exception;
}
