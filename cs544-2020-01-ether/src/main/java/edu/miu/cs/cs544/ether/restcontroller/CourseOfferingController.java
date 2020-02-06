package edu.miu.cs.cs544.ether.restcontroller;

import java.util.List;

import edu.miu.cs.cs544.ether.dal.entity.CourseOffering;

public interface CourseOfferingController {
	List<CourseOffering> getCourseOfferings();
	List<CourseOffering> getCourseOfferings(long courseId);
	void deleteCourseOffering(long courseOfferingId);
	CourseOffering createCourseOffering(CourseOffering courseOffering) throws Exception;
	CourseOffering getCourseOffering(long courseOfferingId);
	CourseOffering updateCourseOffering(CourseOffering courseOffering);
	List<CourseOffering> getCourseOfferings(String courseId);
}
