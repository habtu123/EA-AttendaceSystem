//package edu.miu.cs.cs544.ether.service;
//
//import edu.miu.cs.cs544.ether.dal.entity.Course;
//import edu.miu.cs.cs544.ether.dal.entity.CourseOffering;
//import edu.miu.cs.cs544.ether.dal.repository.CourseOfferingRepository;
//import edu.miu.cs.cs544.ether.dal.repository.CourseRepository;
//import edu.miu.cs.cs544.ether.service.impl.CourseOfferingServiceImpl;
//import edu.miu.cs.cs544.ether.service.impl.CourseServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//public class CourseOfferingMockTest {
//
//    @Mock
//    private CourseOfferingRepository courseOfferingRepository;
//
//    @InjectMocks
//    private CourseOfferingService courseOfferingService = new CourseOfferingServiceImpl();
//
//    private List<CourseOffering> courseOfferings = Arrays.asList(
//            new CourseOffering(1001, new Course(null, "CS437", "ALG", "Algorithms"), ),
//            new Course(null, "CS437", "ALG", "Algorithms"),
//            new Course(null, "CS445", "WAP", "Web bla bla"));
//
//    @BeforeEach
//    void setMockOutput() {
//        when(courseRepository.findAll()).thenReturn(courses);
//        when(courseRepository.getOne(courses.get(1).getId())).thenReturn(courses.get(1));
//        when(courseRepository.save(courses.get(1))).thenReturn(courses.get(1));
//    }
//
//    @Test
//    void testGetCourses() {
//        assertEquals(courses, courseService.getCourses());
//    }
//
//    @Test
//    void testGetCourse() {
//        assertEquals(courses.get(1), courseService.getCourse(courses.get(1).getCourseId()));
//    }
//
//    @Test
//    void testSaveCourse() {
//        assertEquals(courses.get(1), courseService.getCourse(courses.get(1).getCourseId()));
//    }
//
//
//}
