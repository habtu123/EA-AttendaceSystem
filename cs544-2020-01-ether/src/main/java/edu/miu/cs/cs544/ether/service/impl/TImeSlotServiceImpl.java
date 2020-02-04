package edu.miu.cs.cs544.ether.service.impl;

import edu.miu.cs.cs544.ether.dal.entitiy.TimeSlot;
import edu.miu.cs.cs544.ether.dal.repository.TimeSlotRepository;
import edu.miu.cs.cs544.ether.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TImeSlotServiceImpl implements TimeSlotService {
    @Autowired
    private TimeSlotRepository timeSlotRepository;
    @Override
    public List<TimeSlot> getTimeSlot() {
        List<TimeSlot>  timeSlots = timeSlotRepository.findAll();
        if(timeSlots != null)
            return timeSlots;
        return null;
    }
}
