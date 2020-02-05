package edu.miu.cs.cs544.ether.auth.dal.repository;

import edu.miu.cs.cs544.ether.auth.dal.entitiy.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}
