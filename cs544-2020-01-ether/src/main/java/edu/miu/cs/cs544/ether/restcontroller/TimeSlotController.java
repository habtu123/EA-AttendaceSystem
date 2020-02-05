package edu.miu.cs.cs544.ether.restcontroller;

import java.util.List;

import edu.miu.cs.cs544.ether.dal.entity.TimeSlot;

public interface TimeSlotController {

    List<TimeSlot> getAll() throws Exception;
    public TimeSlot getById(String abbreviation);
    public TimeSlot create(TimeSlot timeSlot);
    public TimeSlot update(TimeSlot timeSlot,String abbreviation);
    public void delete(String abbreviation);
}
