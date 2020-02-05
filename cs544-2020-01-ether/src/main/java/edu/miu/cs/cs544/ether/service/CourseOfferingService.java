package edu.miu.cs.cs544.ether.service;

import java.util.List;

import edu.miu.cs.cs544.ether.dal.entity.CourseOffering;

public interface CourseOfferingService {
	List<CourseOffering> getCourseOfferings();
	List<CourseOffering> getCourseOfferings(long courseId);
	void deleteCourseOffering(long courseOfferingId);
	CourseOffering createCourseOffering(CourseOffering courseOffering) throws Exception;
	CourseOffering getCourseOffering(long courseOfferingId);
	CourseOffering updateCourseOffering(CourseOffering courseOffering);
}
