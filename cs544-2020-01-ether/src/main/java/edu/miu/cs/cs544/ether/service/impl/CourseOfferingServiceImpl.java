package edu.miu.cs.cs544.ether.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.cs544.ether.dal.entity.CourseOffering;
import edu.miu.cs.cs544.ether.dal.repository.CourseOfferingRepository;
import edu.miu.cs.cs544.ether.service.CourseOfferingService;
import edu.miu.cs.cs544.ether.service.CourseService;
import edu.miu.cs.cs544.ether.service.StudentService;

@Service
public class CourseOfferingServiceImpl implements CourseOfferingService {

	@Autowired
	private CourseOfferingRepository courseOfferingRepository;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;

	@Override
	@Transactional(propagation= Propagation.REQUIRES_NEW, readOnly =true)
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<CourseOffering> getCourseOfferings() {
		List<CourseOffering> courseOfferings = courseOfferingRepository.findAll();
		if(courseOfferings != null)
            return courseOfferings;
        return null;
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRES_NEW, readOnly =true)
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<CourseOffering> getCourseOfferings(long courseId) {
		return courseOfferingRepository.findAll().stream().filter(c -> c.getCourse().getId().equals(courseId))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional(propagation= Propagation.REQUIRES_NEW, readOnly =true)
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<CourseOffering> getCourseOfferings(String courseId) {
		return courseOfferingRepository.findAll().stream().filter(c -> c.getCourse().getCourseId().equals(courseId))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRES_NEW)
	@PreAuthorize("hasAuthority('ADMIN')")
	public void deleteCourseOffering(long courseOfferingId) {
		Optional<CourseOffering> course = courseOfferingRepository.findAll().stream()
				.filter(c -> c.getCourseOfferingId().equals(courseOfferingId)).findFirst();
		if (course != null) {
			courseOfferingRepository.deleteById(course.get().getId());
		}
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRES_NEW, readOnly =true)
	@PreAuthorize("hasAuthority('ADMIN')")
	public CourseOffering getCourseOffering(long courseOfferingId) {
		Optional<CourseOffering> course = courseOfferingRepository.findAll().stream()
				.filter(c -> c.getCourseOfferingId().equals(courseOfferingId)).findFirst();
		if (course != null) {
			return course.get();
		}
		return null;
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRES_NEW)
	@PreAuthorize("hasAuthority('ADMIN')")
	public CourseOffering updateCourseOffering(CourseOffering courseOffering){
		Optional<CourseOffering> course = courseOfferingRepository.findAll().stream()
				.filter(c -> c.getCourseOfferingId().equals(courseOffering.getId())).findFirst();
		if (course != null) {
			course.get().setCourse(courseOffering.getCourse());
			course.get().setEndDate(courseOffering.getEndDate());
			course.get().setStartDate(courseOffering.getStartDate());
			return courseOfferingRepository.save(courseOffering);
		}
		return null;
		
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRES_NEW)
	@PreAuthorize("hasAuthority('ADMIN')")
	public CourseOffering createCourseOffering(CourseOffering courseOffering) throws Exception {
		if(courseOffering == null) {
			throw new Exception("Course offering cannot be empty");
		}
		
		if(studentService.getById(courseOffering.getStudent().getId()) == null) {
			throw new Exception("Student not found");
		}
		
		if(courseService.getCourse(courseOffering.getCourse().getId()) == null) {
			throw new Exception("Invalid course");
		}
		
		return courseOfferingRepository.save(courseOffering);		
		
	}



}
