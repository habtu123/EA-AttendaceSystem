package edu.miu.cs.cs544.ether.service.impl;

import edu.miu.cs.cs544.ether.dal.entity.Student;

import edu.miu.cs.cs544.ether.dal.repository.StudentRepository;
import edu.miu.cs.cs544.ether.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> getAll() throws Exception {

        List<Student> students = studentRepository.findAll();
        if(students == null)
            throw new Exception("No Students found!!");
        return students;
    }

    @Override
    public Student getStudentBy(Predicate<Student> predicate) throws Exception {

        return null;
    }

    @Override
    @Transactional(readOnly =true)
    public Student getByStudentId(String studentId) throws Exception {
//        List<Student> student=studentRepository.findAll().stream().filter().collect(Collectors.toList());
//        student.orElseThrow(()->new RuntimeException("No Student Record Found."));
//        return student.get();
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Student getById(Long Id) {
        Optional<Student> student=studentRepository.findById(Id);
        student.orElseThrow(()->new RuntimeException("No Student Record Found."));
        return student.get();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Student create(@Valid Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Student update(Student student) {
        studentRepository.save(student);
        return null;
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Student getStudent(Long Id) throws Exception {
        Student student=studentRepository.findById(Id).get();
        if(student==null){
        	return null;
        }
        return student;

    }

    @Override
    public void delete(Student student) {studentRepository.delete(student);
    }
}
