package edu.miu.cs.cs544.ether.dal.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs544.ether.dal.entity.Attendance;
import edu.miu.cs.cs544.ether.dal.entity.CourseOffering;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

}
