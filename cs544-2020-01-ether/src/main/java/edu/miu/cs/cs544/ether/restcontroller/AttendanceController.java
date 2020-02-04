package edu.miu.cs.cs544.ether.restcontroller;

import java.util.List;

import edu.miu.cs.cs544.ether.dal.entitiy.Attendance;
import edu.miu.cs.cs544.ether.dal.entitiy.CourseOffering;

public interface AttendanceController {
	List<Attendance> getAttendances();
	List<Attendance> getAttendances(Long courseOfferingId, String studentId);
	List<Attendance> getAttendances(Long courseOfferingId);
	List<Attendance> getAttendances(String studentId);
}
