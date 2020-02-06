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
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.ether.dal.entity.CourseOffering;
import edu.miu.cs.cs544.ether.dal.entity.TimeSlot;
import edu.miu.cs.cs544.ether.restcontroller.CourseOfferingController;
import edu.miu.cs.cs544.ether.service.CourseOfferingService;
import edu.miu.cs.cs544.ether.service.TimeSlotService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CourseOfferingControllerImpl implements CourseOfferingController {
	@Autowired
	private CourseOfferingService courseOfferingService;

	@ApiOperation(value = "Get a list of all course offerings", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
	@GetMapping(value = "/courseofferings", produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public List<CourseOffering> getCourseOfferings() {
		return courseOfferingService.getCourseOfferings();
	}

	@ApiOperation(value = "Get specific courseoffering", response = CourseOffering.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved courseoffering"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
	@GetMapping(value = "/courseofferings/{courseOfferingId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public CourseOffering getCourseOffering(@PathVariable long courseOfferingId) {
		return courseOfferingService.getCourseOffering(courseOfferingId);
	}

	@ApiOperation(value = "Get a list of courseofferings for a course", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
	@GetMapping(value = "/courseofferings/course/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public List<CourseOffering> getCourseOfferings(@PathVariable long courseId) {
		return courseOfferingService.getCourseOfferings(courseId);
	}
	
	@ApiOperation(value = "Get a list of courseofferings for a course", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
	@GetMapping(value = "/courseofferings/course/id/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public List<CourseOffering> getCourseOfferings(@PathVariable String courseId) {
		return courseOfferingService.getCourseOfferings(courseId);
	}

	@ApiOperation(value = "Create a new course offering", response = CourseOffering.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created courseoffering"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
	@PostMapping(value = "/courseofferings", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public CourseOffering createCourseOffering(@RequestBody CourseOffering courseOffering) throws Exception {
		return courseOfferingService.createCourseOffering(courseOffering);
	}

	@ApiOperation(value = "Delete a course offering")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted courseoffering"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
	@DeleteMapping(value = "/courseofferings/course/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public void deleteCourseOffering(@PathVariable long courseOfferingId) {
		courseOfferingService.deleteCourseOffering(courseOfferingId);
	}

	@ApiOperation(value = "Update a course offering", response = CourseOffering.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated courseoffering"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
	@PutMapping(value = "/courseofferings", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public CourseOffering updateCourseOffering(@RequestBody CourseOffering courseOffering) {
		return courseOfferingService.updateCourseOffering(courseOffering);
	}
}
