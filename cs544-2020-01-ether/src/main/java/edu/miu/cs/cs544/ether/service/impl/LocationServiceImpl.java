package edu.miu.cs.cs544.ether.service.impl;

import edu.miu.cs.cs544.ether.dal.entity.Location;
import edu.miu.cs.cs544.ether.dal.repository.LocationRepository;
import edu.miu.cs.cs544.ether.service.CourseOfferingService;
import edu.miu.cs.cs544.ether.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;
    
    @Autowired
    private CourseOfferingService courseOfferingService;

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Location addLocation(Location newLocation){
        return locationRepository.save(newLocation);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW, readOnly =true)
    @PreAuthorize("hasAnyAuthority('ADMIN','FACULTY')")
    public List<Location> getLocations(){
        return locationRepository.findAll();
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW, readOnly =true)
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Location getLocationById(Long locationId){

        return locationRepository.findById(locationId).get();
    }
    
    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW, readOnly =true)
    @PreAuthorize("hasAnyAuthority('ADMIN', 'FACULTY')")
    public Location getLocationByCourseOffering(Long courseOfferingId){

        return courseOfferingService.getCourseOfferings().stream()
        		.filter(c -> c.getCourseOfferingId().equals(courseOfferingId))
        		.map(m -> m.getLocation())
        		.findFirst().get();
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void deleteLocation(Long locationId){
        locationRepository.deleteById(locationId);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Location updateLocation(Location updatedLocation){

        return  locationRepository.save(updatedLocation);
    }
}
