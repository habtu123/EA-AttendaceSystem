package edu.miu.cs.cs544.ether.restcontroller.impl;

import edu.miu.cs.cs544.ether.dal.entity.TimeSlot;
import edu.miu.cs.cs544.ether.restcontroller.TimeSlotController;
import edu.miu.cs.cs544.ether.service.TimeSlotService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TimeSlotControllerImpl implements TimeSlotController {
    @Autowired
    private TimeSlotService timeSlotService;
    @ApiOperation(value = "View a list of available time slot", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
    @Override
    @GetMapping(value = "/timeslots", produces = MediaType.APPLICATION_JSON_VALUE)
    @Secured({"ADMIN","FACULTY"})
    public List<TimeSlot> getAll() throws Exception {
        return timeSlotService.getAll();
    }

    @ApiOperation(value = "View a particular TimeSlot", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @GetMapping(value="/timeslots/abbreviation/{abbreviation}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public TimeSlot getById(@PathVariable String abbreviation) {
        return timeSlotService.getById(abbreviation);
    }

    @ApiOperation(value = "Create new TimeSlot", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/timeslots",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public TimeSlot create(@RequestBody @Valid TimeSlot timeSlot) {
        return timeSlotService.create(timeSlot);
    }

    @ApiOperation(value = "Update a particular TimeSlot", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @Override
    @PutMapping(value = "/timeslots/abbreviation/{abbreviation}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public TimeSlot update(@RequestBody @Valid TimeSlot timeSlot,@PathVariable String abbreviation ) {
        TimeSlot currentTimeSlot=timeSlotService.getById(abbreviation);
        if (currentTimeSlot!=null)
            timeSlotService.update(timeSlot);
        return timeSlot;
    }

    @ApiOperation(value = "Delete a particular TimeSlot", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @Override
    @DeleteMapping(value = "/timeslots/abbreviation/{abbreviation}")
    public void delete(@PathVariable String abbreviation) {
        TimeSlot timeSlot=timeSlotService.getById(abbreviation);
        if (timeSlot!=null)
            timeSlotService.delete(timeSlot);
    }
}
