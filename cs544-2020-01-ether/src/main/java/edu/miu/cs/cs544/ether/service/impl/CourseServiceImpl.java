package edu.miu.cs.cs544.ether.service.impl;

import edu.miu.cs.cs544.ether.dal.entity.Course;
import edu.miu.cs.cs544.ether.dal.repository.CourseRepository;
import edu.miu.cs.cs544.ether.service.CourseService;
import edu.miu.cs.cs544.ether.service.customexpection.CourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getCourses() throws CourseNotFoundException {
        List<Course> courses = courseRepository.findAll();
        if (courses == null || courses.size() == 0)
            throw new CourseNotFoundException("No courses available!");
        return courses;
    }

    @Override
    public Course getCourse(Long id) throws CourseNotFoundException {
        Optional<Course> course = courseRepository.findById(id);
        if (!course.isPresent())
            throw new CourseNotFoundException("Course not found!");
        return course.get();
    }

    @Override
    public Course getCourse(String courseId) throws CourseNotFoundException {
        Optional<Course> course = getCourses().stream()
                .filter(a -> a.getCourseId().equals(courseId)).findFirst();
        if (!course.isPresent())
            throw new CourseNotFoundException("Course not found!");
        return course.get();
    }

    @Override
    public Course saveCourse(Course course) throws RuntimeException {
        System.out.println(course);

        Course c = courseRepository.save(course);
        if (c == null)
            throw new RuntimeException("Failed to create course!");
        return c;
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void deleteCourse(String courseId) throws RuntimeException {
        Optional<Course> course = getCourses().stream()
                .filter(a -> a.getCourseId().equals(courseId)).findFirst();
        if (!course.isPresent())
            throw new RuntimeException("Course not found!");
        deleteCourse(course.get().getCourseId());
    }
}
