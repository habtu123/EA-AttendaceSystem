package edu.miu.cs.cs544.ether.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs544.ether.dal.entity.TimeSlot;

import java.util.List;
import java.util.Optional;


@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, String> {

    //	  Optional<TimeSlot> findTimeSlotById(long TimeSlotId);
//	    Optional<TimeSlot> deleteTimeSlotById(long TimeSlotId);
//		void delete(String name);
    Optional<TimeSlot> findById(String abbreviation);

}
