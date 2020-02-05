package edu.miu.cs.cs544.ether.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs544.ether.dal.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
