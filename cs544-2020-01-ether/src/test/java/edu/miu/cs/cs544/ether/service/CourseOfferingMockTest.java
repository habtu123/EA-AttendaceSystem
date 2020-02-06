package edu.miu.cs.cs544.ether.service;

import edu.miu.cs.cs544.ether.dal.entity.Course;
import edu.miu.cs.cs544.ether.dal.entity.CourseOffering;
import edu.miu.cs.cs544.ether.dal.entity.Student;
import edu.miu.cs.cs544.ether.dal.repository.CourseOfferingRepository;
import edu.miu.cs.cs544.ether.dal.repository.CourseRepository;
import edu.miu.cs.cs544.ether.service.impl.CourseOfferingServiceImpl;
import edu.miu.cs.cs544.ether.service.impl.CourseServiceImpl;
import lombok.SneakyThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CourseOfferingMockTest {

    @Mock
    private CourseOfferingRepository courseOfferingRepository;

    @InjectMocks
    private CourseOfferingService courseOfferingService = new CourseOfferingServiceImpl();

    private List<CourseOffering> courseOfferings = Arrays.asList(
            new CourseOffering(1001L, new Course("CS437", "ALG", "Algorithms"), new Date(2019, 11,10),
            		new Date(2019, 11,20), new Student("100", "1001")),
            new CourseOffering(1002L, new Course("CS420", "WAP", "Web"), new Date(2019, 11,1),
            		new Date(2019, 11,30), new Student("100", "1001"))); 

    @BeforeEach
    void setMockOutput() {
        
    }

    @Test
    void testGetCourseOfferings() {
    	when(courseOfferingRepository.findAll()).thenReturn(courseOfferings);
        assertEquals(courseOfferings, courseOfferingService.getCourseOfferings());
        verify(courseOfferingRepository).findAll();
    }

    @Test
    void testGetCourseOffering() {
        when(courseOfferingRepository.findById(1001L)).thenReturn(Optional.of(courseOfferings.get(0)));
        assertEquals(courseOfferings.get(0), courseOfferingService.getCourseOffering(1001L));
        verify(courseOfferingRepository).findById(1001L);
    }

    @Test
    @SneakyThrows
    void testSaveCourseOffering() {
        when(courseOfferingRepository.save(courseOfferings.get(1))).thenReturn(courseOfferings.get(1));
        assertEquals(courseOfferings.get(1), courseOfferingService.createCourseOffering(courseOfferings.get(1)));
        verify(courseOfferingRepository).save(courseOfferings.get(1));
    }


}
