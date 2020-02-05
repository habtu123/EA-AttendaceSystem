package edu.miu.cs.cs544.ether.service;

import edu.miu.cs.cs544.ether.dal.entity.Course;
import edu.miu.cs.cs544.ether.dal.repository.CourseRepository;
import edu.miu.cs.cs544.ether.service.impl.CourseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CourseServiceMockTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseService courseService = new CourseServiceImpl();

    private List<Course> courses = Arrays.asList(
            new Course("CS544", "EA", "Enter bla Bla"),
            new Course("CS437", "ALG", "Algorithms"),
            new Course("CS445", "WAP", "Web bla bla"));

    @BeforeEach
    void setMockOutput() {
        when(courseRepository.findAll()).thenReturn(courses);
    }

    @Test
    void testGetCourses() {
        assertEquals(courses, courseService.getCourses());
        verify(courseRepository).findAll();
    }

    @Test
    void testGetCourse() {
        when(courseRepository.getOne(courses.get(1).getId())).thenReturn(courses.get(1));
        assertEquals(courses.get(1), courseService.getCourse(courses.get(1).getId()));
        verify(courseRepository).getOne(courses.get(1).getId());
    }

    @Test
    void testGetCourseByCourseId() {
        assertEquals(courses.get(1), courseService.getCourse(courses.get(1).getCourseId()));
    }


    @Test
    void testSaveCourse() {
        when(courseRepository.save(courses.get(1))).thenReturn(courses.get(1));
        assertEquals(courses.get(1), courseService.saveCourse(courses.get(1)));
        verify(courseRepository).save(courses.get(1));
    }


}
