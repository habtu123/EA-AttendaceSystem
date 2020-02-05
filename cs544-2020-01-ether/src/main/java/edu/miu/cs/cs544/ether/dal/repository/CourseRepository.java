package edu.miu.cs.cs544.ether.dal.repository;

import edu.miu.cs.cs544.ether.dal.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CourseRepository extends JpaRepository <Course, Long>{

}
