package edu.miu.cs.cs544.ether.service;

import java.util.List;

import edu.miu.cs.cs544.ether.dal.entity.Attendance;
import edu.miu.cs.cs544.ether.dal.entity.CourseOffering;
import edu.miu.cs.cs544.ether.dal.entity.Student;

public interface AttendanceService {
	List<Attendance> getAttendances();
	List<Attendance> getAttendances(Long courseOfferingId, String studentId);
	List<Attendance> getAttendances(Long courseOfferingId);
	List<Attendance> getAttendance(String studentId);
}
