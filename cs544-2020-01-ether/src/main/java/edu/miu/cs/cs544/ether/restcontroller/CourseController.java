package edu.miu.cs.cs544.ether.restcontroller;

import edu.miu.cs.cs544.ether.dal.entity.Course;

import java.util.List;

public interface CourseController {
    public List<Course> getCourses();
    public Course getCourse(Long id);
    public Course getCourse(String courseId);
    public Course saveCourse(Course course);
    public void deleteCourse(String courseId);
}
