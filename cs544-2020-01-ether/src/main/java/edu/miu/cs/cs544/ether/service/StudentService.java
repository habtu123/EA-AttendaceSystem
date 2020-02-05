package edu.miu.cs.cs544.ether.service;


import java.util.List;
import java.util.function.Predicate;

import edu.miu.cs.cs544.ether.dal.entity.Student;

public interface StudentService {

   public  List<Student> getAll() throws Exception;
   public  Student getStudentBy(Predicate<Student> predicate) throws Exception;
   public  Student getByStudentId(String studentId) throws Exception;
   public Student getById(Long Id);
   public Student create(Student student);
   public Student update(Student student);
   public void delete(Student student);

}
