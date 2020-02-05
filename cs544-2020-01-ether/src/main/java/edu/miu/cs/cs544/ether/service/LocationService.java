package edu.miu.cs.cs544.ether.service;

import edu.miu.cs.cs544.ether.dal.entity.Location;

import java.util.List;

public interface LocationService {
    public void addLocation(Location newLocation);

    public List<Location> getLocations();

    public Location getLocationById(Long locationId);

    public void deleteLocation(Long locationId);

    public void updateLocation(Location updatedLocation);
}
