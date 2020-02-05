package edu.miu.cs.cs544.ether.restcontroller;


import edu.miu.cs.cs544.ether.dal.entity.Student;

import java.util.List;

public interface StudentController {
    List<Student> getAll() throws Exception;
    //public Student getById(Long Id);
    public Student getByStudentId(String studentId) throws Exception;
    public Student create(Student Student);
    public Student update(Student Student,String studentId) throws Exception;
    public void delete(String studentId) throws Exception;
}
