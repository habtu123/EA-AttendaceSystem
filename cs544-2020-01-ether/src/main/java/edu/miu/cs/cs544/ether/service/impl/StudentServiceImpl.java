package edu.miu.cs.cs544.ether.service.impl;

import edu.miu.cs.cs544.ether.dal.entity.Student;

import edu.miu.cs.cs544.ether.dal.repository.StudentRepository;
import edu.miu.cs.cs544.ether.exception.StudentNotFoundException;
import edu.miu.cs.cs544.ether.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Transactional(propagation= Propagation.REQUIRES_NEW, readOnly =true)
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Student> getAll() throws StudentNotFoundException {
        List<Student> students = studentRepository.findAll();
        if(students == null)
            throw new StudentNotFoundException("No Students found!!");
        return students;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW, readOnly =true)
    @PreAuthorize("hasAuthority('ADMIN')")
    public Student getStudentBy(Predicate<Student> predicate) throws StudentNotFoundException {
        return null;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW, readOnly =true)
    @PreAuthorize("hasAuthority('ADMIN')")
    public Student getByStudentId(String studentId) throws StudentNotFoundException {
        Optional<Student> student=studentRepository.findAll().stream().filter(x->x.getStudentId().equals((studentId))).findFirst();
        Student result = null;
        if (student.isPresent()){
            result=student.get();
        }else{
            throw new StudentNotFoundException("No Student Found-"+ studentId);
        }
        return result;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW, readOnly =true)
    @PreAuthorize("hasAuthority('ADMIN')")
    public Student getById(Long Id) throws StudentNotFoundException {
        Optional<Student> student=studentRepository.findById(Id);
        student.orElseThrow(()->new StudentNotFoundException("No Student Record Found."));
        return student.get();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @PreAuthorize("hasAuthority('ADMIN')")
    public Student create(@Valid Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @PreAuthorize("hasAuthority('ADMIN')")
    public Student update(@Valid Student student) {
        Student studentUpdated= studentRepository.save(student);
        return studentUpdated;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(Student student) {
        studentRepository.delete(student);
    }
}
