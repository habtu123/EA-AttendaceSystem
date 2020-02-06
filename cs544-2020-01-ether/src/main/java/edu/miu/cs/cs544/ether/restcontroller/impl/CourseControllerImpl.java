package edu.miu.cs.cs544.ether.restcontroller.impl;

import edu.miu.cs.cs544.ether.dal.entity.Course;
import edu.miu.cs.cs544.ether.restcontroller.CourseController;
import edu.miu.cs.cs544.ether.service.CourseService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseControllerImpl implements CourseController {

    @Autowired
    private CourseService courseService;

    @ApiOperation(value = "View a list of available courses", response = List.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved course list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    @ApiImplicitParams({
        @ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
	
    @GetMapping(value = "/Courses", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        try {
            courses = courseService.getCourses();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            return courses;
        }
    }

    @ApiOperation(value = "Get a course by Surrogate Id", response = Course.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved course"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    @ApiImplicitParams({
        @ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
	
    @GetMapping(value = "/Course/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Course getCourse(@PathVariable Long id) {
        Course course = null;
        try {
            course = courseService.getCourse(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return course;
    }

    @ApiOperation(value = "Get a course by CourseId", response = Course.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved course"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    @ApiImplicitParams({
        @ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
	
    @GetMapping(value = "/Course/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Course getCourse(@PathVariable String courseId) {
        Course course = null;
        try {
            course = courseService.getCourse(courseId);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return course;
    }

    @ApiOperation(value = "Save a course", response = Course.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully saved course"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    @ApiImplicitParams({
        @ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
	
    @PostMapping(value = "/Course", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Course saveCourse(@RequestBody Course course) {
        Course saved = null;
        try {
            saved = courseService.saveCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        finally {
            return saved;
        }
    }

    @ApiOperation(value = "Delete a course", response = void.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully deleted course"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    @ApiImplicitParams({
        @ApiImplicitParam(name = "Auth ", value = "JWT Auth Token", required = true, dataType = "string", paramType = "header") })
	
    @DeleteMapping(value = "/Course/{courseId}")
    @Override
    public void deleteCourse(@PathVariable String courseId) {
        try {
            courseService.deleteCourse(courseId);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            return;
        }
    }
}
