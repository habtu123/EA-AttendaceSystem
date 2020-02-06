package edu.miu.cs.cs544.ether.service.impl;

import edu.miu.cs.cs544.ether.dal.entity.TimeSlot;
import edu.miu.cs.cs544.ether.dal.repository.TimeSlotRepository;
import edu.miu.cs.cs544.ether.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class TimeSlotServiceImpl implements TimeSlotService {
	@Autowired
	private TimeSlotRepository timeSlotRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
	@PreAuthorize("hasAnyAuthority('ADMIN','FACULTY')")
	public List<TimeSlot> getAll() throws Exception {
		List<TimeSlot> timeSlots = timeSlotRepository.findAll();
		if (timeSlots == null)
			throw new Exception("No data of available.");
		return timeSlots;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
	@PreAuthorize("hasAnyAuthority('ADMIN','FACULTY')")
	public TimeSlot getById(String abbreviation) {
		Optional<TimeSlot> timeSlot = timeSlotRepository.findById(abbreviation);
		timeSlot.orElseThrow(() -> new RuntimeException("No timeslot record found."));
		return timeSlot.get();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public TimeSlot create(@Valid TimeSlot timeSlot) {
		return timeSlotRepository.save(timeSlot);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public TimeSlot update(TimeSlot timeSlot) {
		TimeSlot updatedTimeSlot = timeSlotRepository.save(timeSlot);
		return updatedTimeSlot;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public void delete(TimeSlot timeSlot) {
		timeSlotRepository.delete(timeSlot);
	}
}
