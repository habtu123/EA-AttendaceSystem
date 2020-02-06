package edu.miu.cs.cs544.ether.service.impl;

import edu.miu.cs.cs544.ether.dal.entity.Course;
import edu.miu.cs.cs544.ether.dal.repository.CourseRepository;
import edu.miu.cs.cs544.ether.exception.CourseNotFoundException;
import edu.miu.cs.cs544.ether.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW, readOnly = true)
    //@PreAuthorize("hasRole('ADMIN')")
    public List<Course> getCourses() throws CourseNotFoundException {
        List<Course> courses = courseRepository.findAll();
        if (courses == null || courses.size() == 0)
            throw new CourseNotFoundException("No courses available!");
        return courses;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    //@PreAuthorize("hasRole('ADMIN')")
    public Course getCourse(Long id) throws CourseNotFoundException {
        Course course = courseRepository.getOne(id);
        if (course == null)
            throw new CourseNotFoundException("Course not found!");
        return course;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    //@PreAuthorize("hasRole('ADMIN')")
    public Course getCourse(String courseId) throws CourseNotFoundException {
        Optional<Course> course = getCourses().stream()
                .filter(a -> a.getCourseId().equals(courseId)).findFirst();
        if (!course.isPresent())
            throw new CourseNotFoundException("Course not found!");
        return course.get();
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    //@PreAuthorize("hasRole('ADMIN')")
    public Course saveCourse(Course course) throws RuntimeException {
        System.out.println(course);

        Course c = courseRepository.save(course);
        if (c == null)
            throw new RuntimeException("Failed to create course!");
        return c;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
   // @PreAuthorize("hasRole('ADMIN')")
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    //@PreAuthorize("hasRole('ADMIN')")
    public void deleteCourse(String courseId) throws RuntimeException {
        Optional<Course> course = getCourses().stream()
                .filter(a -> a.getCourseId().equals(courseId)).findFirst();
        if (!course.isPresent())
            throw new RuntimeException("Course not found!");
        deleteCourse(course.get().getId());
    }
}
