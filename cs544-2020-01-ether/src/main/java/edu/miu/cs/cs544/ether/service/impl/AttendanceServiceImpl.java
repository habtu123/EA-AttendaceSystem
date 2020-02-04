package edu.miu.cs.cs544.ether.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs544.ether.dal.entitiy.Attendance;
import edu.miu.cs.cs544.ether.dal.entitiy.CourseOffering;
import edu.miu.cs.cs544.ether.dal.entitiy.Student;
import edu.miu.cs.cs544.ether.dal.repository.AttendanceRepository;
import edu.miu.cs.cs544.ether.dal.repository.CourseOfferingRepository;
import edu.miu.cs.cs544.ether.service.AttendanceService;
import edu.miu.cs.cs544.ether.service.CourseOfferingService;
import edu.miu.cs.cs544.ether.service.StudentService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseOfferingService courseOfferingService;
	
//	@Autowired
//	private CourseService courseService;

	@Override
	public List<Attendance> getAttendances() {
		List<Attendance> attendance = attendanceRepository.findAll();
		if(attendance != null)
            return attendance;
        return null;
	}

	@Override
	public List<Attendance> getAttendances(Long courseOfferingId) {
		return attendanceRepository.findAll()
				.stream()
				.filter(c -> c.getDate().after(courseOfferingService.getCourseOffering(courseOfferingId).getStartDate()) && c.getDate().before(courseOfferingService.getCourseOffering(courseOfferingId).getEndDate()))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<Attendance> getAttendances(String studentId) {
		return attendanceRepository.findAll()
				.stream()
				.filter(c -> c.getStudent().getStudentId().equals(studentId))
				.collect(Collectors.toList());
	}

	@Override
	public List<Attendance> getAttendances( Long courseOfferingId, String studentId) {
		return attendanceRepository.findAll()
				.stream()
				.filter(c -> c.getStudent().getStudentId().equals(studentId) && c.getDate().after(courseOfferingService.getCourseOffering(courseOfferingId).getStartDate()) && c.getDate().before(courseOfferingService.getCourseOffering(courseOfferingId).getEndDate()))
				.collect(Collectors.toList());
	}

}
