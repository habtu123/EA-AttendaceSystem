package edu.miu.cs.cs544.ether.service.impl;

import edu.miu.cs.cs544.ether.dal.entity.Student;
import edu.miu.cs.cs544.ether.dal.repository.StudentRepository;
import edu.miu.cs.cs544.ether.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> listOfStudent()  throws Exception {
        List<Student> students = studentRepository.findAll();
        if(students == null)
            throw new Exception("No Students found!!");
        return students;
    }

    @Override
    public Student getStudent(Predicate<Student> predicate) throws Exception {
        return null;
    }

    @Override
    public Student getStudent(Long Id) throws Exception {
        Student student=studentRepository.findById(Id).get();
        if(student==null){

        }
        return null;
    }
}
