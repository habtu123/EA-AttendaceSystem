package edu.miu.cs.cs544.ether.restcontroller;

import java.util.Date;
import java.util.List;

import edu.miu.cs.cs544.ether.dal.entity.Attendance;
import edu.miu.cs.cs544.ether.dal.entity.CourseOffering;
import edu.miu.cs.cs544.ether.dal.entity.Student;

public interface AttendanceController {
	List<Attendance> getAttendances() throws Exception;
	List<Attendance> getAttendances(Long courseOfferingId, String studentId);
	List<Student> getAttendances(Long courseOfferingId);
	List<Attendance> getAttendance(String studentId);
	Attendance takeAttendance(String barCodeId, String date, String timeAbbvr, String locationId);
}
