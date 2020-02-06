package edu.miu.cs.cs544.ether.restcontroller.impl;

import edu.miu.cs.cs544.ether.dal.entity.Location;

import edu.miu.cs.cs544.ether.restcontroller.LocationController;

import edu.miu.cs.cs544.ether.service.LocationService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationControllerImpl implements LocationController {

    @Autowired
    private LocationService locationService;

    @ApiImplicitParams({
        @ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
    @PostMapping(value = "locations", produces = MediaType.APPLICATION_JSON_VALUE)
    public Location addLocation(@RequestBody Location newLocation){
        locationService.addLocation(newLocation);
        return newLocation;
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
    @GetMapping(value = "/locations", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Location> getLocations(){
        return locationService.getLocations();
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
    @GetMapping(value = "/locations/{locationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Location getLocationById(@PathVariable Long locationId){
        return locationService.getLocationById(locationId);
    }
    
    @ApiImplicitParams({
        @ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
    @GetMapping(value = "/locations/courseoffering/{courseOfferingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Location getLocationByCourseOffering(@PathVariable Long courseOfferingId){
        return locationService.getLocationByCourseOffering(courseOfferingId);
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
    @DeleteMapping(value = "/locations/{locationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteLocation(@PathVariable Long locationId){
        locationService.deleteLocation(locationId);
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
    @RequestMapping(value="/locations/{locationId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateLocation(@PathVariable Long locationId, @RequestBody Location updatedLocation){
        //because this is a PUT, all fields are mandatory. Alternative would be to use the PATCH HTTP verb
        //TODO: Add functionality to validate that all fields have been passed
        Location existingLocation = locationService.getLocationById(locationId);
        BeanUtils.copyProperties(updatedLocation, existingLocation, "locationId");
        locationService.updateLocation(existingLocation);
    }
}
