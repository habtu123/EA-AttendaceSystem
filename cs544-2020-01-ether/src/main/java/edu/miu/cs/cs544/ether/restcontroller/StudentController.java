package edu.miu.cs.cs544.ether.restcontroller;


import edu.miu.cs.cs544.ether.dal.entity.Student;
import edu.miu.cs.cs544.ether.exception.StudentNotFoundException;

import java.util.List;

public interface StudentController {
    List<Student> getAll();
    //public Student getById(Long Id) ;
    public Student getByStudentId(String studentId) throws StudentNotFoundException;
    public Student create(Student Student);
    public Student update(Student Student,String studentId);
    public void delete(String studentId);
}
