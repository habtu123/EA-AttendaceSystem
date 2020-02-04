package edu.miu.cs.cs544.ether.service;

import edu.miu.cs.cs544.ether.dal.entitiy.Student;

import java.util.List;

public interface StudentService {
   public  List<Student> listOfStudent() throws Exception;
}
