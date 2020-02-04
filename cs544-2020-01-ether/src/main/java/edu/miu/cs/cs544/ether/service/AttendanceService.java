package edu.miu.cs.cs544.ether.service;

import java.util.List;

import edu.miu.cs.cs544.ether.dal.entitiy.Attendance;
import edu.miu.cs.cs544.ether.dal.entitiy.CourseOffering;
import edu.miu.cs.cs544.ether.dal.entitiy.Student;

public interface AttendanceService {
	List<Attendance> getAttendances();
	List<Attendance> getAttendances(Long courseOfferingId, String studentId);
	List<Attendance> getAttendances(Long courseOfferingId);
	List<Attendance> getAttendances(String studentId);
}
