package edu.miu.cs.cs544.ether.service.impl;

import edu.miu.cs.cs544.ether.dal.entity.Location;
import edu.miu.cs.cs544.ether.dal.repository.LocationRepository;
import edu.miu.cs.cs544.ether.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public void addLocation(Location newLocation){
        locationRepository.save(newLocation);
    }

    @Override
    public List<Location> getLocations(){
        return locationRepository.findAll();
    }

    @Override
    public Location getLocationById(Long locationId){
        return locationRepository.getOne(locationId);
    }

    @Override
    public void deleteLocation(Long locationId){
        locationRepository.deleteById(locationId);
    }

    @Override
    public void updateLocation(Location updatedLocation){
        locationRepository.save(updatedLocation);
    }
}
