package edu.miu.cs.cs544.ether.service.impl;

import edu.miu.cs.cs544.ether.dal.entitiy.Student;
import edu.miu.cs.cs544.ether.dal.repository.StudentRepository;
import edu.miu.cs.cs544.ether.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> listOfStudent()  throws Exception {

        List<Student> students = studentRepository.findAll();
        if(students == null)
            throw new Exception("no Students foudn!!");
        return students;
    }
}
