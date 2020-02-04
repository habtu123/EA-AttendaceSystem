package edu.miu.cs.cs544.ether.dal.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs544.ether.dal.entitiy.CourseOffering;

@Repository
public interface CourseOfferingRepository extends JpaRepository<CourseOffering, Long> {

}
