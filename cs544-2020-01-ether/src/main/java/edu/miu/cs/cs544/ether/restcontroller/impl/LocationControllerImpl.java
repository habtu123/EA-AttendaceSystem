package edu.miu.cs.cs544.ether.restcontroller.impl;

import edu.miu.cs.cs544.ether.dal.entitiy.Location;

import edu.miu.cs.cs544.ether.restcontroller.LocationController;

import edu.miu.cs.cs544.ether.service.LocationService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/locations/")
public class LocationControllerImpl implements LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Location addLocation(@RequestBody Location newLocation){
        locationService.addLocation(newLocation);
        return newLocation;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Location> getLocations(){
        return locationService.getLocations();
    }

    @GetMapping(value = "{locationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Location getLocationById(@PathVariable Long locationId){
        return locationService.getLocationById(locationId);
    }

    @DeleteMapping(value = "/delete/{locationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteLocation(@PathVariable Long locationId){
        locationService.deleteLocation(locationId);
    }

    @RequestMapping(value="/update/{locationId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateLocation(@PathVariable Long locationId, @RequestBody Location updatedLocation){
        //because this is a PUT, all fields are mandatory. Alternative would be to use the PATCH HTTP verb
        //TODO: Add functionality to validate that all fields have been passed
        Location existingLocation = locationService.getLocationById(locationId);
        BeanUtils.copyProperties(updatedLocation, existingLocation, "locationId");
        locationService.updateLocation(existingLocation);
    }
}
