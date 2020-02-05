package edu.miu.cs.cs544.ether.auth.dal.repository;

import edu.miu.cs.cs544.ether.auth.dal.entitiy.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, String> {
}
