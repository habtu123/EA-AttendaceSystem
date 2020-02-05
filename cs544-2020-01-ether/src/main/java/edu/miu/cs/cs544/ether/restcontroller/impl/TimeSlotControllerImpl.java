package edu.miu.cs.cs544.ether.restcontroller.impl;

import edu.miu.cs.cs544.ether.dal.Greeting;
import edu.miu.cs.cs544.ether.dal.entitiy.TimeSlot;
import edu.miu.cs.cs544.ether.restcontroller.TimeSlotController;
import edu.miu.cs.cs544.ether.service.TimeSlotService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeSlotControllerImpl implements TimeSlotController {
    @Autowired
    private TimeSlotService timeSlotService;

    @ApiOperation(value = "View a list of available student", response = List.class)


    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
    @GetMapping(value = "/timeSlots", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public List<TimeSlot> getTimeSlot() {
        return timeSlotService.getTimeSlot();
    }
}
