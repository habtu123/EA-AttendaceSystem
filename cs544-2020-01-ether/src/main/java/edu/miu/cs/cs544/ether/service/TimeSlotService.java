package edu.miu.cs.cs544.ether.service;

import edu.miu.cs.cs544.ether.dal.entitiy.TimeSlot;

import java.util.List;

public interface TimeSlotService {

    public List<TimeSlot> getAll() throws Exception;
    public TimeSlot getById(String abbreviation);
    public TimeSlot create(TimeSlot timeSlot);
    public TimeSlot update(TimeSlot timeSlot);
    public void delete(TimeSlot timeSlot);

}
