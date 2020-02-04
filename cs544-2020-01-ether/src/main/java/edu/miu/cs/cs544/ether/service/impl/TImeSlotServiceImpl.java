package edu.miu.cs.cs544.ether.service.impl;

import edu.miu.cs.cs544.ether.dal.entitiy.TimeSlot;
import edu.miu.cs.cs544.ether.dal.repository.TimeSlotRepository;
import edu.miu.cs.cs544.ether.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class TImeSlotServiceImpl implements TimeSlotService {
    @Autowired
    private TimeSlotRepository timeSlotRepository;
    @Override
    public List<TimeSlot> getAll() throws Exception {
        List<TimeSlot>  timeSlots = timeSlotRepository.findAll();
        if(timeSlots == null)
            throw new Exception("No data of available.");
        return timeSlots;
    }

    @Override
    public TimeSlot getById(String abbreviation) {
        Optional<TimeSlot> timeSlot=timeSlotRepository.findById(abbreviation);
        timeSlot.orElseThrow(()->new RuntimeException("No timeslot record found."));
        return timeSlot.get();
    }

    @Override
    public TimeSlot create(@Valid TimeSlot timeSlot) {
       return timeSlotRepository.save(timeSlot);
    }

    @Override
    public TimeSlot update(TimeSlot timeSlot) {
        timeSlotRepository.save(timeSlot);
        return null;
    }

    @Override
    public void delete(TimeSlot timeSlot) {
        timeSlotRepository.delete(timeSlot);
    }
}
