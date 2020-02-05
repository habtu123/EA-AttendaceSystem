package edu.miu.cs.cs544.ether.restcontroller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.ether.dal.entity.Attendance;
import edu.miu.cs.cs544.ether.dal.entity.CourseOffering;
import edu.miu.cs.cs544.ether.dal.entity.TimeSlot;
import edu.miu.cs.cs544.ether.restcontroller.AttendanceController;
import edu.miu.cs.cs544.ether.restcontroller.CourseOfferingController;
import edu.miu.cs.cs544.ether.service.AttendanceService;
import edu.miu.cs.cs544.ether.service.CourseOfferingService;
import edu.miu.cs.cs544.ether.service.TimeSlotService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AttendanceControllerImpl implements AttendanceController {
	@Autowired
	private AttendanceService attendanceService;

	@ApiOperation(value = "Get a list of all attendances", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/attendances", produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public List<Attendance> getAttendances() {
		return attendanceService.getAttendances();
	}
	
	@ApiOperation(value = "Get attendance for a student for a course offering", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved courseoffering"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/attendances/{courseOfferingId}/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public List<Attendance> getAttendances(@PathVariable Long courseOfferingId, @PathVariable String studentId) {
		return attendanceService.getAttendances(courseOfferingId, studentId);
	}

	@ApiOperation(value = "Get specific courseoffering", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved courseoffering"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/attendances/{courseOfferingId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public List<Attendance> getAttendances(@PathVariable Long courseOfferingId) {
		return attendanceService.getAttendances(courseOfferingId);
	}

	@ApiOperation(value = "Get all the attendance of a student", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved courseoffering"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/attendance", produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public List<Attendance> getAttendance(@RequestParam(value="studentId") String studentId) {
		return attendanceService.getAttendance(studentId);
	}

}
