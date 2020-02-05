package edu.miu.cs.cs544.ether.service;


import java.util.List;
import java.util.function.Predicate;

import edu.miu.cs.cs544.ether.dal.entity.Student;
import edu.miu.cs.cs544.ether.exception.StudentNotFoundException;

public interface StudentService {

   public  List<Student> getAll() throws StudentNotFoundException;
   public  Student getStudentBy(Predicate<Student> predicate) throws StudentNotFoundException;
   public  Student getByStudentId(String studentId) throws StudentNotFoundException;
   public Student getById(Long Id) throws StudentNotFoundException;
   public Student create(Student student) throws StudentNotFoundException;
   public Student update(Student student);
   public void delete(Student student);

}
