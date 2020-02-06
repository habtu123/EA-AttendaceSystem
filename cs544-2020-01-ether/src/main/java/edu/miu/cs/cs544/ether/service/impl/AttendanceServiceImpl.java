package edu.miu.cs.cs544.ether.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.cs544.ether.dal.entity.Attendance;
import edu.miu.cs.cs544.ether.dal.entity.Location;
import edu.miu.cs.cs544.ether.dal.entity.Student;
import edu.miu.cs.cs544.ether.dal.entity.TimeSlot;
import edu.miu.cs.cs544.ether.dal.repository.AttendanceRepository;
import edu.miu.cs.cs544.ether.service.AttendanceService;
import edu.miu.cs.cs544.ether.service.CourseOfferingService;
import edu.miu.cs.cs544.ether.service.LocationService;
import edu.miu.cs.cs544.ether.service.StudentService;
import edu.miu.cs.cs544.ether.service.TimeSlotService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired 
	private LocationService locationService;
	
	@Autowired
	private TimeSlotService timeSlotService;
	
	@Autowired
	private CourseOfferingService courseOfferingService;
	
	@Override
	@Transactional(propagation= Propagation.REQUIRES_NEW, readOnly =true)
	@PreAuthorize("hasRole('ADMIN')")
	public List<Attendance> getAttendances() {
		List<Attendance> attendance = attendanceRepository.findAll();
		if(attendance != null)
            return attendance;
        return null;
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRES_NEW, readOnly =true)
	@PreAuthorize("hasRole('ADMIN')")
	public List<Attendance> getAttendances(Long courseOfferingId) {
		return attendanceRepository.findAll()
				.stream()
				.filter(c -> !c.getDate().before(courseOfferingService.getCourseOffering(courseOfferingId).getStartDate()) && !c.getDate().after(courseOfferingService.getCourseOffering(courseOfferingId).getEndDate()))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional(propagation= Propagation.REQUIRES_NEW, readOnly =true)
	@PreAuthorize("hasRole('ADMIN')")
	public List<Attendance> getAttendance(String studentId) {
		return attendanceRepository.findAll()
				.stream()
				.filter(c -> c.getStudent().getStudentId().equals(studentId))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRES_NEW, readOnly =true)
	@PreAuthorize("hasRole('ADMIN')")
	public List<Attendance> getAttendances(Long courseOfferingId, String studentId) {
		return attendanceRepository.findAll()
				.stream()
				.filter(c -> c.getStudent().getStudentId().equals(studentId))
				.filter(c -> !c.getDate().before(courseOfferingService.getCourseOffering(courseOfferingId).getStartDate()) && !c.getDate().after(courseOfferingService.getCourseOffering(courseOfferingId).getEndDate()))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRES_NEW)
	@PreAuthorize("hasRole('ADMIN')")
	public Attendance takeAttendance(String barCodeId, String date, String timeAbbvr, String locationId) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
		
		Date date_real = formatter.parse(date);
		Student student = studentService.getAll()
				.stream()
				.filter(c -> c.getBarCodeId().equals(barCodeId))
				.findFirst().get();
		Location location = locationService.getLocations()
				.stream()
				.filter(c -> c.getLocationId().equals(locationId))
				.findFirst().get();
		TimeSlot timeSlot = timeSlotService.getById(timeAbbvr);
		if(student!= null && location != null && timeSlot != null) {
			Attendance att = new Attendance(student, date_real, location, timeSlot);
			attendanceRepository.save(att);
			return att;
		}
		return null;
	}


}
