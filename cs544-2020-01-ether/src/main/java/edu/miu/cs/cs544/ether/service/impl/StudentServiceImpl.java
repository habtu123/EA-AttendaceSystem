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
    @Transactional(readOnly =true)
    public Student getStudentBy(Predicate<Student> predicate) throws Exception {
        return null;
    }

    @Override
    @Transactional(readOnly =true)
    public Student getByStudentId(String studentId) throws Exception {
        Optional<Student> student=studentRepository.findAll().stream().filter(x->x.getStudentId().equals((studentId))).findFirst();
        Student result = null;
        if (student.isPresent()){
            result=student.get();
        }else{
            throw new RuntimeException("No Student Found-"+ studentId);
        }
        return result;
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
    public Student update(@Valid Student student) {
        Student studentUpdated= studentRepository.save(student);
        return studentUpdated;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete(Student student) {
        studentRepository.delete(student);
    }
}
