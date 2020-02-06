package edu.miu.cs.cs544.ether.service;

import java.util.Date;
import java.util.List;

import edu.miu.cs.cs544.ether.dal.entity.Attendance;
import edu.miu.cs.cs544.ether.dal.entity.CourseOffering;
import edu.miu.cs.cs544.ether.dal.entity.Student;

public interface AttendanceService {
	List<Attendance> getAttendances() throws Exception;
	List<Attendance> getAttendances(Long courseOfferingId, String studentId) throws Exception;
	List<Student> getAttendances(Long courseOfferingId) throws Exception;
	List<Attendance> getAttendance(String studentId) throws Exception;
	Attendance takeAttendance(String barCodeId, String date, String timeAbbvr, String locationId) throws Exception;
}
