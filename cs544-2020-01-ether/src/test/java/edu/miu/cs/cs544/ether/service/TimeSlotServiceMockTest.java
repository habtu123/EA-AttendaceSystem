package edu.miu.cs.cs544.ether.service;

import edu.miu.cs.cs544.ether.dal.entity.TimeSlot;
import edu.miu.cs.cs544.ether.dal.repository.TimeSlotRepository;
import edu.miu.cs.cs544.ether.service.impl.TImeSlotServiceImpl;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TimeSlotServiceMockTest {
    @Mock
    private TimeSlotRepository timeSlotRepository;

    @InjectMocks
    private TimeSlotService timeSlotService = new TImeSlotServiceImpl();

    private List<TimeSlot> timeSlots = Arrays.asList(
            new TimeSlot("AM", "Morning class", new Time(10), new Time(12)),
            new TimeSlot("PM", "Afternoon class", new Time(13), new Time(15)));


    @Test
    @SneakyThrows
    void testGetTimeSlots() {
        when(timeSlotRepository.findAll()).thenReturn(timeSlots);
        assertEquals(timeSlots, timeSlotService.getAll());
        verify(timeSlotRepository).findAll();
    }

    @Test
    void testGetTimeSlot() {
        when(timeSlotRepository.findById("AM")).thenReturn(Optional.of(timeSlots.get(0)));
        assertEquals(timeSlots.get(0), timeSlotService.getById(timeSlots.get(0).getAbbreviation()));
        verify(timeSlotRepository).findById(timeSlots.get(0).getAbbreviation());
    }

    @Test
    void testSaveTimeSlot() {
        when(timeSlotRepository.save(timeSlots.get(1))).thenReturn(timeSlots.get(1));
        assertEquals(timeSlots.get(1), timeSlotService.create(timeSlots.get(1)));
        verify(timeSlotRepository).save(timeSlots.get(1));
    }
}
