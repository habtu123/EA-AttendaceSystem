package edu.miu.cs.cs544.ether.service;

import edu.miu.cs.cs544.ether.service.impl.customexpection.CourseNotFoundException;
import edu.miu.cs.cs544.ether.dal.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    public List<Course> getCourses() throws CourseNotFoundException;
    public Course getCourse(Long id) throws  CourseNotFoundException;
    public Course getCourse(String courseId) throws CourseNotFoundException;
    public Course saveCourse(Course course) throws RuntimeException;
    public void deleteCourse(Long id);
    public void deleteCourse(String courseId) throws RuntimeException;
}
